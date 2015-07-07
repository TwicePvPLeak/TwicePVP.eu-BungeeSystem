package de.Feuerwolf1.TwicePvPBungeeSystem;

public enum TimeManager
{
  S("Sekunde(n)", 1L),  SEC("Sekunde(n)", 1L),  M("Minute(n)", 60L),  MIN("Minute(n)", 60L),  H("Stunde(n)", 3600L),  HOUR("Stunde(n)", 3600L),  D("Tag(e)", 86400L),  DAY("Tag(e)", 86400L),  W("Woche(n)", 604800L),  WEEK("Woche(n)", 604800L);
  
  private String output;
  private long toSec;
  
  private TimeManager(String output, long toSec)
  {
    this.output = output;
    this.toSec = toSec;
  }
  
  public String getOutput()
  {
    return this.output;
  }
  
  public long getToSec()
  {
    return this.toSec;
  }
}
