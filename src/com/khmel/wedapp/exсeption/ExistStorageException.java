package com.khmel.wedapp.exсeption;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}