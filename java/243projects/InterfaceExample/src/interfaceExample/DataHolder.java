package interfaceExample;

public class DataHolder<T> {              // makes the DataHolder class generic, so it can take any data type

    // Fields
    T data;                               // T is the convention for generic

    // constructors
    DataHolder(T theInfo) {
        data = theInfo;
    }

    // methods
    T getData() {
        return data;
    }

    void setData(T newData) {
        data = newData;
    }
}
