package com.hfad.notetoself;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database
{
    private static ArrayList<Note> noteList;

    public static ArrayList<Note> getNotes()
    {
        if (noteList == null)
        {
            loadData();
        }

        return noteList;
    }

    public static void addNote(String noteStatus, String noteTitle, String noteContents)
    {
        noteList.add(new Note(noteStatus, noteTitle, noteContents));
    }

    private static void loadData()
    {
        noteList = new ArrayList<>();

        ArrayList<String> statuses = new ArrayList<String>();
        statuses.add("Important");
        statuses.add("To-do");
        statuses.add("Idea");
        statuses.add("To-do");
        statuses.add("Important");
        statuses.add("Idea");
        statuses.add("Important");
        statuses.add("To-do");
        statuses.add("Idea");
        statuses.add("Important");

        ArrayList<String> titles = new ArrayList<String>();
        titles.add("Encryption Quiz");
        titles.add("Security Assignment");
        titles.add("Vulnerability Exam");
        titles.add("Database Project");
        titles.add("Calculus Exam");
        titles.add("Systems Quiz");
        titles.add("Forensics Practical");
        titles.add("Cyber Capstone");
        titles.add("Art Assignment");
        titles.add("Literature Quiz");

        ArrayList<String> contents = new ArrayList<String>();
        contents.add("Quiz on Digital Signatures.");
        contents.add("Assignment on Kali Linux.");
        contents.add("Exam on Chapters 1-3.");
        contents.add("Project on SQL.");
        contents.add("Questions 1-9.");
        contents.add("Quiz on Windows 10.");
        contents.add("Practical in EnCase.");
        contents.add("Capstone project.");
        contents.add("Gothic architecture.");
        contents.add("Quiz on Robinson Crusoe.");

        for (int i = 0; i < contents.size(); i++)
        {
            noteList.add(new Note(statuses.get(i), titles.get(i), contents.get(i)));
        }

        //System.out.println(noteList.size());
    }

}