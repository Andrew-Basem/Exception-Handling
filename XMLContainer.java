
public class XMLContainer implements Comparable<XMLContainer> {
    private String id;
    private String shortName;
    private String longName;

    public XMLContainer(String id, String shortName, String longName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }

    @Override
    public String toString() {
        return  "       <CONTAINER "+ id + ">" + "\n" +
                "          <SHORT-NAME>"+shortName+"</SHORT-NAME>"+ "\n" +
                "          <LONG-NAME>"+longName+"</LONG-NAME>" +"\n" +
                "       </CONTAINER>";
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }


    public String getLongName() {
        return longName;
    }


    @Override
    public int compareTo(XMLContainer c) {
        return this.getShortName().compareTo(c.getShortName());

    }
}

