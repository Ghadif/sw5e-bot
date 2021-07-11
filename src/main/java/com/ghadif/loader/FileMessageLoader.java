package com.ghadif.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
@RequiredArgsConstructor
public class FileMessageLoader extends GenericMessageLoader {

    private final ResourceLoader resourceLoader;

    @Override
    protected String loadMessage(String messageName) throws IOException {
        Resource resource = resourceLoader
                .getResource("classpath:messages/"
                        .concat(messageName)
                        .concat(".dat"));

        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }
}
