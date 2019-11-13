package alekseybykov.portfolio.whitepappers.services.file;

import alekseybykov.portfolio.whitepappers.entities.Whitepapper;

import java.io.InputStream;

public interface FilesService {

    void saveFile(String fileName, Whitepapper whitepapper, InputStream stream);

    Integer moveAllFilesToTheCloud();
}
