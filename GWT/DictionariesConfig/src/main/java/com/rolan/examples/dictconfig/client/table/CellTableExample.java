package com.rolan.examples.dictconfig.client.table;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UiTemplate("CellTableExample.ui.xml")
public class CellTableExample extends Composite {

    @UiField(provided = true)
    CellTable<ContactInfo> cellTable;
    @UiField(provided = true)
    SimplePager pager;

    interface CellTableExampleUiBinder extends UiBinder<Widget, CellTableExample> {
    }

    private static CellTableExampleUiBinder uiBinder = GWT.create(CellTableExampleUiBinder.class);

    public CellTableExample() {
        cellTable = new CellTable<>();
        SelectionModel<ContactInfo> selectionModel = new MultiSelectionModel<>();
        cellTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<ContactInfo>createCheckboxManager());
        ListDataProvider<ContactInfo> dataProvider = new ListDataProvider<>();
        dataProvider.setList(getContactsList());
        dataProvider.addDataDisplay(cellTable);

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(cellTable);

        initTableColumns(selectionModel, dataProvider);
        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initTableColumns(final SelectionModel<ContactInfo> selectionModel, final ListDataProvider<ContactInfo> dataProvider) {
        Column<ContactInfo, Boolean> checkColumn = new Column<ContactInfo, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(ContactInfo object) {
                // Get the value from the selection model.
                return selectionModel.isSelected(object);
            }


        };
        cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        cellTable.setColumnWidth(checkColumn, 40, Style.Unit.PX);

        Column<ContactInfo, String> firstNameColumn = new Column<ContactInfo, String>(new TextCell()) {
            @Override
            public String getValue(ContactInfo object) {
                return object.getFirstName();
            }
        };
        cellTable.addColumn(firstNameColumn, TableConstants.INSTANCE.contactFirstName());
        cellTable.setColumnWidth(firstNameColumn, 200, Style.Unit.PX);

        Column<ContactInfo, String> lastNameColumn = new Column<ContactInfo, String>(new EditTextCell()) {
            @Override
            public String getValue(ContactInfo object) {
                return object.getLastName();
            }
        };
        lastNameColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {
            @Override
            public void update(int index, ContactInfo object, String value) {
                object.setLastName(value);
            }
        });
        cellTable.addColumn(lastNameColumn, TableConstants.INSTANCE.contactLastName());
        cellTable.setColumnWidth(lastNameColumn, 200, Style.Unit.PX);

        Column<ContactInfo, Boolean> isDefaultColumn = new Column<ContactInfo, Boolean>(new CheckboxCell(true, true)) {
            @Override
            public Boolean getValue(ContactInfo object) {
                return object.isDefault();
            }
        };
        isDefaultColumn.setFieldUpdater(new FieldUpdater<ContactInfo, Boolean>() {
            @Override
            public void update(int index, ContactInfo object, Boolean value) {
                if (value != null && value) {
                    for (ContactInfo info : dataProvider.getList()) {
                        if (info.isDefault()) {
                            info.setDefault(false);
                        }
                    }
                }
                object.setDefault(value);
                dataProvider.refresh();
            }
        });
        cellTable.addColumn(isDefaultColumn, TableConstants.INSTANCE.defaultContact());
        cellTable.setColumnWidth(isDefaultColumn, 20, Style.Unit.PX);
    }

    private List<ContactInfo> getContactsList() {
        List<ContactInfo> dataList = new ArrayList<>();
        Random randomGenerator = new Random();
        for (int i = 0; i < 50; i++) {
            ContactInfo info = new ContactInfo();
            if (i == 0) {
               info.setDefault(true);
            }
            info.setFirstName(TableData.FEMALE_FIRST_NAMES[randomGenerator.nextInt(TableData.FEMALE_FIRST_NAMES.length)]);
            info.setLastName(TableData.LAST_NAMES[randomGenerator.nextInt(TableData.LAST_NAMES.length)]);
            dataList.add(info);
        }
        return dataList;
    }
}