package com.gmail.slisenko.dm.getgif.dao;

import java.io.IOException;
import java.util.List;

public interface GifDao {

    List<String> getGifs() throws IOException;

}
