package epocha.service;

import java.util.List;
import java.io.IOException;

import epocha.Date;

public interface DateReaderService
{
    List<List<Date>> getDates(String path) throws IOException;
}
