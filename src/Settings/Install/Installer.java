/**
 * @Description:        IInstaller interface would to use some classes to set some data
 * @Author:             Quentin Le Bian <quentin>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Installer.java
 * @Date:               2017-11-05T01:32:52+01:00
 * @Last modified by:   quentin
 * @Last modified time: 2017-11-05T03:30:41+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Settings.Install;

import src.Settings.Install.IInstaller;
import src.Settings.Vet.*;

public class Installer implements IInstaller {

 protected Vet    checker = new Vet();

 public Installer(){
   System.out.println("*** Installation done! ***");
 }
}
