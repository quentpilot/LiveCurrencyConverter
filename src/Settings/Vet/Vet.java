/**
 * @Description:        Object class would to do some stuff
 * @Author:             Quentin Le Bian <quentin>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Vet.java
 * @Date:               2017-11-05T02:18:51+01:00
 * @Last modified by:   quentin
 * @Last modified time: 2017-11-05T03:14:55+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Settings.Vet;

import src.Settings.Vet.AVet;
import src.Settings.Vet.IVet;

public class Vet extends AVet {

  protected UserVet[]   user_check = {new UserVet(), new AccountVet()};
  protected APIVet[]    app_check = {new APIVet(), new ConfigVet(), new UpdateVet()};

  public Vet(){}
}
