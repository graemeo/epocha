package epocha.service;

import java.util.List;
import java.io.IOException;

public interface DateReaderService
{
    List<String> getDatesFromInputFile(String path) throws IOException;
}
