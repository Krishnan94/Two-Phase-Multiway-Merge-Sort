package com.concordia.mergesort;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Readingfile {
	static int sublists = 0;
	public static void readingFile(String filePath, int numOfRecords, int memoryRecords ) throws IOException {
		// Record[] arr = new Record[numOfRecords];
				 		 
		
		try {
		
			FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bin=new BufferedInputStream(fis); 
			Input inputFile = new Input(bin);
		//int totalRecords = inputFile.ReadInt();
			//String Size		= inputFile.ReadString();
			//System.out.println(totalRecords + Size);
			int i=0;
			int j=0;
			ArrayList<Integer> recordArray = new ArrayList<>();
			while(i<numOfRecords)
			{
				int k = (inputFile.ReadInt());
				if(k>0)
				{
				recordArray.add(k);
				}
				i++;
				
				//System.out.println(i);
				/*if(recordArray.get(j)==-1)
				{
					break;
				}*/
					
				if(j==memoryRecords)
				{
					Collections.sort(recordArray);
					writeIt( recordArray);
					recordArray.clear();
					j=0;					
				}
				j++;
			}
			if(!recordArray.isEmpty())
			{
				Collections.sort(recordArray);
				writeIt( recordArray);
			}
			
			
			System.out.println("out");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
	private static void writeIt(ArrayList<Integer> Filedata) throws IOException {
		
		
		
		
	      //  FileChannel fc = null;
	        try {
	        	
	                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Test\\" + sublists + ".txt"));
	               // ByteBuffer buf = file.map(FileChannel.MapMode.READ_WRITE, 0, 4 * Filedata.length);
	               // System.out.println(Filedata.size());
	                for(int i:Filedata) 
	                {
	                	
	                writer.write(String.valueOf(i));
	                writer.write("\n");
	                
	                //writer.write(str);
	                }
	                writer.close();
	              } catch (IOException e) {
	                throw new RuntimeException(e);
	              } finally {
	            	 
	            	  
	            	  sublists++;
	              }
	            }


}

class  Input
{
	
	
	BufferedInputStream bin;
	int key;
	boolean start; 

	public Input(InputStream inputs)
	{
		bin = new BufferedInputStream(inputs);
		try {
			int i=0;
		}
		catch(Exception e)
		{
			
		}
	}
	public int ReadInt() throws IOException 
    { 
        int ret = 0; 
        StringBuilder sb=new StringBuilder();
        key = bin.read(); 
        while (key <= ' ' && key!=-1)        	
            key = bin.read(); 
        boolean neg = (key == '-'); 
        if (neg) 
        	key = bin.read(); 
        do
        { 
            ret = ret * 10 + key - '0'; 
        }  while ((key = bin.read()) >= '0' && key <= '9'); 

        if (neg) 
            return -ret; 
        return ret; 
    } 
	
	public String ReadString() throws IOException
	{
		StringBuilder sb=new StringBuilder();
		key = bin.read(); 
		//System.out.println(key);
		return String.valueOf(key);
	}
	}
		
		
		
	


