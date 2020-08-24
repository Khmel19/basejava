package com.khmel.webapp.exсeption;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}