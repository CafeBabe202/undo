package top.cafebabe.undo.file.bean.form;

import lombok.Data;

/**
 * @author cafababe
 */
@Data
public class FileUploadInitForm {
    private String fileName;
    private String md5;
    private long allSize;
}
