//package musicPlayer;
//Why package is written here ?
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//I don't know these class yet

import java.io.*;
//This is a general attempt to include everything, I don't have much idea


public class Main {

    public static void main(String[] args){

        String filePath= "RickRoll'D.wav";
        File file = new File(filePath);

        // The try in parenthesis is used, so that the objects used here like Scanner can be closed automatically
        // by Java(have to learn/find accurate word for this)
        try(AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            Scanner sc= new Scanner(System.in)){
                //The above thing is the autoclosable interface

                Clip clip= AudioSystem.getClip();
                clip.open(audio);
                System.out.println("The music is loading");
                
                //clip.start();
                String choice="";
                while(!choice.equals("Q")){
                    //.equals() method is used in Java as String is an object
                    System.out.println("Press P to play: ");
                    System.out.println("Press Q to quit: ");
                    System.out.println("Press R to restart: ");
                    System.out.println("Press S to stop: ");
                    System.out.print("Your response: ");
                    choice= sc.next().toUpperCase();

                    switch(choice){
                    
                        case "P" -> clip.start();
                        case "Q" -> clip.close();
                        case "R" -> clip.setMicrosecondPosition(0);
                        case "S" -> clip.stop();
                        default-> System.out.println("Invalid choice.");
                    }
                }
        }
        catch(FileNotFoundException e){
            System.out.println("Your file is not found");
        }
        catch(LineUnavailableException e){
            System.out.println("There's something wrong with the file ?");
            //LineUnavailableException indicates a sound line cannot be opened because it is unavailable 
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Your audio file is not supported (wav, au, aiff)");
        }
        catch(IOException e){
            System.out.println("Something's wrong here");
        }
        finally{
            System.out.println("See you later!");
        }
    }
    
}
