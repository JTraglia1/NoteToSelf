package com.hfad.notetoself;

public class Note {

    private String noteStatus;
    private String noteTitle;
    private String noteContents;

    public Note(String noteStatus, String noteTitle, String noteContents)
    {
        this.noteStatus = noteStatus;
        this.noteTitle = noteTitle;
        this.noteContents = noteContents;
    }

    public String getNoteStatus() {
        return noteStatus;
    }

    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContents() {
        return noteContents;
    }

    public void setNoteContents(String noteContents) {
        this.noteContents = noteContents;
    }
}

