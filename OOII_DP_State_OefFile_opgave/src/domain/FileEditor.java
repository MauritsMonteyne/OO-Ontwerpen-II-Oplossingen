package domain;

import java.io.File;

public class FileEditor {

	
    private final File file;
    private FileState fileState;
    

    public FileEditor(File file) {
        this.file = file;
        toState(new CleanState(this));
    }

	public boolean save() {
		return fileState.save();
	}

	public boolean edit() {
		return fileState.edit();
	}

	protected void toState(FileState fileState) {
		this.fileState = fileState;
	}

	public File getFile() {
		return file;
	}
}
