package epocha.service;

import java.io.IOException;
import java.util.List;

import epocha.response.Response;

public interface DateService
{
    Response calculateDifferencesBetweenTwoDates() throws IOException;
}
