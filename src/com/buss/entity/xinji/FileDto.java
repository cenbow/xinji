package com.buss.entity.xinji;

public class FileDto {

  private String fileName;
  private String fileSize;
  private String fileType;
  private String filePath;
  
  private byte[] bytes;
  
  public String getFileName() {
    return fileName;
  }
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  public String getFileSize() {
    return fileSize;
  }
  public void setFileSize(String fileSize) {
    this.fileSize = fileSize;
  }
  public String getFileType() {
    return fileType;
  }
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }
  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
  public byte[] getBytes() {
    return bytes;
  }
  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }
}
