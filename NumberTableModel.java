package testGUI;

import javax.swing.table.AbstractTableModel;

//Custom table model for managing number data
public class NumberTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Number","Value"};
    private final Integer[] data = new Integer[8];

    public NumberTableModel() 
    {
        // Initialize with default values
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex] = (Integer) aValue;
        fireTableCellUpdated(rowIndex, columnIndex); // Notify table of update
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}