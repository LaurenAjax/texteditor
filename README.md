# CSC 207: Text Editor

**Author**: _Lauren Ajax_

## Resources Used

+ Java 17.0.14
+ The version of Java I used to write this program.
+ Apache NetBeans
+ The system I used to develop this program.
+ Help from Mentor - Garikai Gijima
+ Helped me figure out how to import the necessary packages
and iron out bugs in my program.
+ Help from Professor - Peter-Michael Osera
+ Helped me fix my pom.xml file, how to use Lanterna in my
program, and impliment screen.clear().
+ Project Page: Text Editor
+ https://osera.cs.grinnell.edu/ttap/data-structures-labs/text-editor.html
+ The page I got my instructions for the project from.
+ TextEditor Github
+ https://github.com/psosera/texteditor
+ The repository I got my starting code from.
+ My TextEditor Repository
+ https://github.com/LaurenAjax/texteditor
+ My forked over repository of the starting code that I cloned.
+ Path API - Oracle Help Center
+ https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html
+ The documentation I referenced to work with the Path class.
+ Paths API - Oracle Help Center
+ https://docs.oracle.com/javase/8/docs/api/java/nio/file/Paths.html
+ The documentation I referenced to work with the Paths class.
+ TextCharacter API
+ https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/TextCharacter.html
+ The documentation I referenced to work with the TextCharacter 
+ class.
+ Lanterna API
+ http://mabe02.github.io/lanterna/apidocs/3.1/overview-summary.html
+ The documentation I referenced to work with Lanterna.
+ KeyStroke API - Oracle Help Center
+ https://docs.oracle.com/javase/8/docs/api/javax/swing/KeyStroke.html
+ The documentation I referenced to work with the KeyStroke 
+ class.
+ Screen API
+ https://mabe02.github.io/lanterna/apidocs/3.0/com/googlecode/lanterna/screen/Screen.html
+ The documentation I referenced to work with the Screen class.
+ Files API - Oracle Help Center
+ https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
+ The documentation I referenced to work with the Files class.
+ Testing Framework Lab
+ https://osera.cs.grinnell.edu/ttap/data-structures-labs/testing-frameworks.html
+ The lab I referenced when writing the various tests for my 
+ program.

## Analysis

In my simple string buffer, I decided the simplest way to 
implement inserting a character into a string would be to 
separate the string into two substring at the cursor position
and then concatenate the first substring, the character, and
the last substring together, in that order. I did this because
strings are immutable, thereby preventing me from simply 
editing the string to contain the character. Furthermore, I 
thought it more efficient to create three new strings, the two
substrings and the string with the character in it, rather than
completely reconstructing the string character by character
using charAt and a for loop. That being said, it is hardly
efficient completely remaking a string every time I want to put
in a single character. To examine the program on a more 
objective level, the relevent inputs of the program are the
character, the string, and the cursor position, and the
critical operation is the string concatenation of the first
substring, the character, and the second substring. Since I am 
constructing two strings with a total length of the original
string plus one additional character, I imagine the 
mathematical model to look like T(n) = n + 1, where n is the 
length of the original string. Thus, the big O characterisation
of the model would be f(n) = O(n).

## Changelog

commit a576369cb826246fab4d3624e9fb8252abf69bc6 (HEAD -> main, origin/main)                                                                     
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 21:36:18 2025 -0600                                                                                                          
                                                                                                                                                
    Added screen.clear to facilitate the accurate performance of delete.                                                                        
                                                                                                                                                
commit 9245eb876f8c0e9426c5cdd708ff84fca69da5d8                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 21:35:40 2025 -0600                                                                                                          
                                                                                                                                                
    Reformatted for optimal style.                                                                                                              
                                                                                                                                                
commit d4a4dd6dfbc0480e05aa66e14d24a705a8223f43                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 21:35:32 2025 -0600                                                                                                          
                                                                                                                                                
    Reformatted for optimal style.                                                                                                              
                                                                                                                                                
commit 4fb7d87cfe495c790afe638ec3618a7f1348a88c                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 21:35:27 2025 -0600                                                                                                          
                                                                                                                                                
    Reformatted for optimal style.                                                                                                              
                                                                                                                                                
commit 6fc451161d8345d29daa365736fa416665b5c5f4                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 21:35:20 2025 -0600                                                                                                          
                                                                                                                                                
    Reformatted for optimal style.                                                                                                              
                                                                                                                                                
commit 14452728f2b3b38fda963088cfb9bbad67fd4714                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Tue Feb 18 00:01:52 2025 -0600                                                                                                          
                           
commit ac46f81a7dcaab5024105a2bff618c5c969a8c62 (HEAD -> main)
Author: ajaxlaur <ajaxlaur@132.161.196.207>
Date:   Tue Feb 18 00:00:35 2025 -0600

    All the references and the commit log added, alongside the analysis.

commit ba2c1516d2f6ff7fbb9d360b5d58e1b10ca93401 (HEAD -> main)                                                                                  
Author: ajaxlaur <ajaxlaur@132.161.196.207>
Date:   Mon Feb 17 01:59:12 2025 -0600

    The documented test for the gap buffer.

commit 5a2b3a105849e34b6579ca715fe09b9cd37b1a68
Author: ajaxlaur <ajaxlaur@132.161.196.207>
Date:   Mon Feb 17 01:51:45 2025 -0600

commit 7fd26573345ef1f6724b70bfed8d80daf58eee20
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Mon Feb 17 01:51:31 2025 -0600                                                                                                          
                                                                                                                                                
    The documented tests for the simple string buffer.                                                                                          
                                                                                                                                                
commit 4b264c5d4ab3ddae4031c3076aeabe998a643f61                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Mon Feb 17 01:38:04 2025 -0600                                                                                                          
                                                                                                                                                
    The text editor as it allows to read and write from a file.                                                                                 
                                                                                                                                                
commit 963beb75aa36deee73ba7b0ccbb1d72330c3099c                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Mon Feb 17 01:37:07 2025 -0600                                                                                                          
                                                                                                                                                
    Nearly finalized version of the gap buffer.                                                                                                 
                                                                                                                                                
commit dc9d94871b9e8cffbfde1b9fc9078fb427de9538                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Mon Feb 17 01:36:52 2025 -0600                                                                                                          
                                                                                                                                                
    Nearly finalized version of the simple string buffer.                                                                                       
                                                                                                                                                
commit 342ce4dd7031e1952ea0870f28f516490410f6eb                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:59:33 2025 -0600                                                                                                          
                                                                                                                                                
    Refined tests.                                                                                                                              
                                                                                                                                                
commit b91f16276ff10d7bdacd37f5183af45fff190a96                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:59:25 2025 -0600                                                                                                          
                                                                                                                                                
    Refined tests.                                                                                                                              
                                                                                                                                                
commit 0417731508d770baff2f1fa9b603020fb92e34bd                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:59:01 2025 -0600                                                                                                          
                                                                                                                                                
    Made all code access the generator.                                                                                                         
                                                                                                                                                
commit 8c2a7165470e3a59c093aadbd04bef2c4d12d96c                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:58:54 2025 -0600                                                                                                          
                                                                                                                                                
    Made all code access the generator.                                                                                                         
                                                                                                                                                
commit fd8fda79cde6e6b732a73d704817477ab8fdcaad                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:11:34 2025 -0600                                                                                                          
                                                                                                                                                
    Fixed a few minor errors and reformatted some code for a smoother run.                                                                      
                                                                                                                                                
commit 66b23952e739c5e7c35521b87aec94d8d89741d1                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 11:10:44 2025 -0600                                                                                                          
                                                                                                                                                
    Added extra lines to ensure successful compile.                                                                                             
                                                                                                                                                
commit 0f65f049817f20391e0ef5f822fe7a598fa111d8                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 01:03:59 2025 -0600                                                                                                          
                                                                                                                                                
    Added rough drafts of all tests.                                                                                                            
                                                                                                                                                
commit 85c7ab7b942495ee4a1a7fb3987d862f0858a7ba                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 01:03:52 2025 -0600                                                                                                          
                                                                                                                                                
    Added rough drafts of all tests.                                                                                                            
                                                                                                                                                
commit ff1eec7da6ef0b202716acf1b4e0fb948a125d2e                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 01:03:38 2025 -0600                                                                                                          
                                                                                                                                                
    Added rough drafts of all functions.                                                                                                        
                                                                                                                                                
commit 7fad22be6a9f563947f95c9b147564a5ec5e517c                                                                                                 
Author: ajaxlaur <ajaxlaur@132.161.196.207>                                                                                                     
Date:   Sat Feb 15 01:02:15 2025 -0600                                                                                                          
                                                                                                                                                
    Added rough drafts of all functions.                                                                                                        
                                                                                                                                                
commit 32a90495f40bd92ce905d4d78fbdab4dbaa6d5f9 (origin/main)                                                                                   
Author: Peter-Michael Osera <osera@cs.grinnell.edu>                                                                                             
Date:   Thu Feb 13 12:40:05 2025 -0600                                                                                                          
                                                                                                                                                
    Project files                                                                                                                               
                                                                                                                                                
commit 02dc92144ecc088bcefb4a9798df0934efe300c1                                                                                                 
Author: Peter-Michael Osera <osera@cs.grinnell.edu>                                                                                             
Date:   Thu Feb 13 12:39:53 2025 -0600                                                                                                          
                                                                                                                                                
    initial commit                                                                                                                              
(END)        
