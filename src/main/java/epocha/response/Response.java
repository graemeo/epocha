package epocha.response;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import epocha.response.DateResponse;

public class Response extends ResourceSupport
{
    private List<DateResponse> dates;
    
    public void setDates(List<DateResponse> dates) {
        this.dates = dates;
    }

    public List<DateResponse> getDates() {
        return dates;
    }
}
