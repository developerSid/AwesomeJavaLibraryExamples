package org.devict.jlib.stdlib;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Gary on 11/2/16.
 * <p>
 * Watching a single file for changes
 */
@SuppressWarnings("unchecked")
public class ExampleFileWatcher
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
      File parent = new File(FileUtils.getTempDirectory(), "/javawatch/");
      File file2Watch = new File(parent, "watch.test");

      parent.mkdirs();

      System.out.printf("Create a file called watch.test in %s\n", parent.getAbsolutePath());

      try(WatchService watchService = FileSystems.getDefault().newWatchService())
      {
         Path parentPath = parent.toPath();

         parentPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

         while(true)
         {
            WatchKey key = watchService.take();

            for(WatchEvent<?> event: key.pollEvents())
            {
               System.out.println("Change detected");

               if(event.kind() == StandardWatchEventKinds.ENTRY_CREATE || event.kind() == StandardWatchEventKinds.ENTRY_MODIFY)
               {
                  WatchEvent<Path> eventWithPath = (WatchEvent<Path>)event;

                  System.out.printf("File created or changed %s + %s\n", eventWithPath.context().toAbsolutePath(), file2Watch.toPath().toAbsolutePath());

                  if(eventWithPath.context().equals(file2Watch.toPath().getFileName()))
                  {
                     System.out.println("File we are watching for created or changed");
                  }
               }
            }

            if(!key.reset())
            {
               break;
            }
         }
      }
      finally
      {
         FileUtils.cleanDirectory(parent);
         parent.delete();
      }
   }
}
