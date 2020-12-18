package domain;

abstract class FileState {

	protected final FileEditor fileEditor;

	public FileState(FileEditor fileEditor) {
		this.fileEditor = fileEditor;
	}

	public boolean save() {
		return false;
	}

	public boolean edit() {
		return false;
	}
}
