package epocha.response;

public class DateResponse
{
    private String firstDate;
    private String secondDate;
    private String differencesInDays;

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public void setDifferencesInDays(String differencesInDays) {
        this.differencesInDays = differencesInDays;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public String getDifferencesInDays() {
        return differencesInDays;
    }
}
