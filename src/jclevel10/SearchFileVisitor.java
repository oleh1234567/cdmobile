package jclevel10;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = Integer.MIN_VALUE;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {

        if (!isPassedCriterion(file)) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    private boolean isPassedCriterion(Path file) throws IOException {
        byte[] content = Files.readAllBytes(file);
        int fileSize = content.length; // File size: content.length

        boolean isNameContains = file.getFileName().toString().contains(partOfName);
        boolean isFileContains = new String(content).contains(partOfContent);
        boolean isSizeIsLessThanMax = fileSize < maxSize;
        boolean isSizeIsGreaterThanMin = fileSize > minSize;


        return isNameContains
                && isFileContains
                && isSizeIsLessThanMax
                && isSizeIsGreaterThanMin;
    }
}
