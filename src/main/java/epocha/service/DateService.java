package epocha.service;

import java.io.IOException;
import java.util.List;

import epocha.response.DateResponse;

public interface DateService
{
    List<DateResponse> calculateDifferencesBetweenTwoDates() throws IOException;
}
