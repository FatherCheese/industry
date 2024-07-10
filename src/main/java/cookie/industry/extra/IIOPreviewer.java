package cookie.industry.extra;

public interface IIOPreviewer {
    IOTypes getType();

    void setPreview(IOTypes type);

    void setTempPreview(IOTypes type, int ticks);

    void disableIOPreview();
}
