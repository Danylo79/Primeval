package dev.dankom.pi.file;

import dev.dankom.file.type.Directory;
import dev.dankom.pi.PrimevalItems;
import dev.dankom.pi.file.yml.YmlFile;

public class FileManager {
    public Directory ROOT = new Directory(PrimevalItems.getInstance().getDataFolder().getAbsolutePath());
    public YmlFile profiles = new YmlFile("profiles", PrimevalItems.getInstance());
}
