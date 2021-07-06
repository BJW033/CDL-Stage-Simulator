package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import model.Group;

public class jUnitTests {
	
	  @Test 
	  public void fourWayBreakTestTwoTwoRecords() { 
		  //A = B > C = D Group GroupA =
	  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 2); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupA.sortStandings();
	  
	  
	  assertTrue(GroupA.getPool().get(0).isDeadtie2());
	  assertTrue(GroupA.getPool().get(1).isDeadtie2());
	  assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  
	  //A >(pool) B > C = D Group GroupB = new
	 Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 2, 3);
	  GroupB.updateMatch("Optic","Legion", 2, 3); GroupB.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupB.updateMatch("Optic", "Thieves", 3, 2);
	  GroupB.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupB.updateMatch("Faze", "Surge", 3, 2); GroupB.updateMatch("Faze",
	  "Legion", 2, 3); GroupB.updateMatch("Faze","Thieves", 3, 2);
	  GroupB.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupB.updateMatch("Thieves","Legion", 1, 3); GroupB.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupB.updateMatch("Rokkr", "Legion",3, 2);
	  GroupB.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupB.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupB.sortStandings();
	  
	  
	  assertTrue(GroupB.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()));
	  assertTrue(GroupB.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName())); 
	  
	  assertFalse(GroupB.getPool().get(0).isDeadtie2()); 
	  assertFalse(GroupB.getPool().get(1).isDeadtie2());
	  assertTrue(GroupB.getPool().get(2).isDeadtie2());
	  assertTrue(GroupB.getPool().get(3).isDeadtie2());
	  
	  
	  //B(pool) >(pool) A > C = D Group GroupC = new
	 Group GroupC = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupC.updateMatch("Optic", "Faze", 2, 3);
	  GroupC.updateMatch("Optic","Legion", 2, 3); GroupC.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupC.updateMatch("Optic", "Thieves", 3, 2);
	  GroupC.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupC.updateMatch("Faze", "Surge", 3, 2); GroupC.updateMatch("Faze",
	  "Legion", 2, 3); GroupC.updateMatch("Faze","Thieves", 3, 2);
	  GroupC.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupC.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupC.updateMatch("Thieves","Legion", 1, 3); GroupC.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupC.updateMatch("Rokkr", "Legion",3, 2);
	  GroupC.updateMatch("Rokkr","Surge",3, 0);
	  
	  GroupC.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupC.sortStandings();
	  
	  assertTrue(GroupC.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupC.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupC.getPool().get(0).isDeadtie2()); assertFalse(GroupC.getPool().get(1).isDeadtie2());
	  assertTrue(GroupC.getPool().get(2).isDeadtie2());
	  assertTrue(GroupC.getPool().get(3).isDeadtie2());
	  
	  
	  //B(pool) >(pool) A > (pool)C > (pool) D Group GroupD = new
	  Group GroupD = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupD.updateMatch("Optic", "Faze", 2, 3);
	  GroupD.updateMatch("Optic","Legion", 2, 3); GroupD.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupD.updateMatch("Optic", "Thieves", 3, 2);
	  GroupD.updateMatch("Optic", "Surge", 3, 1);
	  
	  GroupD.updateMatch("Faze", "Surge", 3, 2); GroupD.updateMatch("Faze",
	  "Legion", 2, 3); GroupD.updateMatch("Faze","Thieves", 3, 2);
	  GroupD.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupD.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupD.updateMatch("Thieves","Legion", 1, 3); GroupD.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupD.updateMatch("Rokkr", "Legion",3, 2);
	  GroupD.updateMatch("Rokkr","Surge",3, 0);
	  
	  GroupD.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupD.sortStandings();
	  
	  assertTrue(GroupD.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupD.getPool().get(0).isDeadtie2()); assertFalse(GroupD.getPool().get(1).isDeadtie2());
	  assertTrue(GroupD.getPool().get(2).getName().equals(GroupA.getPool().get(2).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(3).getName().equals(GroupA.getPool().get(3).getName()))
	  ; assertFalse(GroupD.getPool().get(2).isDeadtie2()); assertFalse(GroupD.getPool().get(3).isDeadtie2());
	  
	  
	  //B(pool) >(pool) A > (pool)D > (pool) C Group GroupE = new
	 Group GroupE = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupE.updateMatch("Optic", "Faze", 2, 3);
	  GroupE.updateMatch("Optic","Legion", 2, 3); GroupE.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupE.updateMatch("Optic", "Thieves", 3, 2);
	  GroupE.updateMatch("Optic", "Surge", 3, 1);
	  
	  GroupE.updateMatch("Faze", "Surge", 3, 0); GroupE.updateMatch("Faze",
	  "Legion", 2, 3); GroupE.updateMatch("Faze","Thieves", 3, 2);
	  GroupE.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupE.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupE.updateMatch("Thieves","Legion", 1, 3); GroupE.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupE.updateMatch("Rokkr", "Legion",3, 2);
	  GroupE.updateMatch("Rokkr","Surge",3, 0);
	  
	  GroupE.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupE.sortStandings();
	  
	  assertTrue(GroupE.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupE.getPool().get(0).isDeadtie2()); assertFalse(GroupE.getPool().get(1).isDeadtie2());
	  assertTrue(GroupE.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupE.getPool().get(2).isDeadtie2()); assertFalse(GroupE.getPool().get(3).isDeadtie2());
	  
	  
	  //A >(map) B > C (map) D Group GroupF = new
	  Group GroupF = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupF.updateMatch("Optic", "Faze", 2, 3);
	  GroupF.updateMatch("Optic","Legion", 1, 3); GroupF.updateMatch("Optic",
	  "Rokkr", 3, 0); GroupF.updateMatch("Optic", "Thieves", 3, 2);
	  GroupF.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupF.updateMatch("Faze", "Surge", 3, 2); GroupF.updateMatch("Faze",
	  "Legion", 2, 3); GroupF.updateMatch("Faze","Thieves", 3, 2);
	  GroupF.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupF.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupF.updateMatch("Thieves","Legion", 1, 3); GroupF.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupF.updateMatch("Rokkr", "Legion",3, 2);
	  GroupF.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupF.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupF.sortStandings();
	  
	  
	  assertTrue(GroupF.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupF.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName()))
	  ; assertFalse(GroupF.getPool().get(0).isDeadtie2()); assertFalse(GroupF.getPool().get(1).isDeadtie2());
	  assertFalse(GroupF.getPool().get(2).isDeadtie2()); assertFalse(GroupF.getPool().get(3).isDeadtie2());
	  
	  //B>(map) A> D(map) C Group GroupG = new
	 Group GroupG = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupG.updateMatch("Optic", "Faze", 1, 3);
	  GroupG.updateMatch("Optic","Legion", 2, 3); GroupG.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupG.updateMatch("Optic", "Thieves", 3, 2);
	  GroupG.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupG.updateMatch("Faze", "Surge", 3, 2); GroupG.updateMatch("Faze",
	  "Legion", 2, 3); GroupG.updateMatch("Faze","Thieves", 3, 2);
	  GroupG.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupG.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupG.updateMatch("Thieves","Legion", 2, 3); GroupG.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupG.updateMatch("Rokkr", "Legion",3, 0);
	  GroupG.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupG.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupG.sortStandings();
	  
	  
	  assertTrue(GroupG.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupG.getPool().get(0).isDeadtie2()); assertFalse(GroupG.getPool().get(1).isDeadtie2());
	  assertFalse(GroupG.getPool().get(2).isDeadtie2()); assertFalse(GroupG.getPool().get(3).isDeadtie2());
	  
	  }
	  
	  
	  @Test 
	  public void fourWayBreakTestTwoTwoRecords2() { //A = C > B = D Group GroupA =
	  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 3, 2);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 2); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",2, 3);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupA.sortStandings();
	  
	  
	  assertTrue(GroupA.getPool().get(0).isDeadtie2());
	  assertTrue(GroupA.getPool().get(1).isDeadtie2());
	  assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  
	  //A >(pool) C > B = D Group GroupB = new
	  Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 3, 2);
	  GroupB.updateMatch("Optic","Legion", 2, 3); GroupB.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupB.updateMatch("Optic", "Thieves", 2, 3);
	  GroupB.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupB.updateMatch("Faze", "Surge", 3, 2); GroupB.updateMatch("Faze",
	  "Legion", 3, 2); GroupB.updateMatch("Faze","Thieves", 3, 2);
	  GroupB.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupB.updateMatch("Thieves","Legion", 0, 3); GroupB.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupB.updateMatch("Rokkr", "Legion",2, 3);
	  GroupB.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupB.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupB.sortStandings();
	  
	  
	  assertTrue(GroupB.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupB.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName()))
	  ; assertFalse(GroupB.getPool().get(0).isDeadtie2()); assertFalse(GroupB.getPool().get(1).isDeadtie2());
	  assertTrue(GroupB.getPool().get(2).isDeadtie2());
	  assertTrue(GroupB.getPool().get(3).isDeadtie2());
	  
	  
	  //C(pool) >(pool)A > B = D Group GroupC = new
	  Group GroupC = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupC.updateMatch("Optic", "Faze", 3, 2);
	  GroupC.updateMatch("Optic","Legion", 2, 3); GroupC.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupC.updateMatch("Optic", "Thieves", 2, 3);
	  GroupC.updateMatch("Optic", "Surge", 3, 0);
	  
	  GroupC.updateMatch("Faze", "Surge", 3, 2); GroupC.updateMatch("Faze",
	  "Legion", 3, 2); GroupC.updateMatch("Faze","Thieves", 3, 2);
	  GroupC.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupC.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupC.updateMatch("Thieves","Legion", 2, 3); GroupC.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupC.updateMatch("Rokkr", "Legion",2, 3);
	  GroupC.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupC.updateMatch("Legion", "Surge", 2, 3); GroupC.sortStandings();
	  
	  assertTrue(GroupC.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupC.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupC.getPool().get(0).isDeadtie2()); assertFalse(GroupC.getPool().get(1).isDeadtie2());
	  assertTrue(GroupC.getPool().get(2).isDeadtie2());
	  assertTrue(GroupC.getPool().get(3).isDeadtie2());
	  
	  
	  //C(pool) >(pool) A > (pool)B > (pool) D Group GroupD = new
	 Group GroupD = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupD.updateMatch("Optic", "Faze", 3, 2);
	  GroupD.updateMatch("Optic","Legion", 2, 3); GroupD.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupD.updateMatch("Optic", "Thieves", 2, 3);
	  GroupD.updateMatch("Optic", "Surge", 3, 0);
	  
	  GroupD.updateMatch("Faze", "Surge", 3, 2); GroupD.updateMatch("Faze",
	  "Legion", 3, 2); GroupD.updateMatch("Faze","Thieves", 3, 2);
	  GroupD.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupD.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupD.updateMatch("Thieves","Legion", 2, 3); GroupD.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupD.updateMatch("Rokkr", "Legion",2, 3);
	  GroupD.updateMatch("Rokkr","Surge",3, 0);
	  
	  GroupD.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupD.sortStandings();
	  
	  assertTrue(GroupD.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupD.getPool().get(0).isDeadtie2()); assertFalse(GroupD.getPool().get(1).isDeadtie2());
	  assertTrue(GroupD.getPool().get(2).getName().equals(GroupA.getPool().get(2).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(3).getName().equals(GroupA.getPool().get(3).getName()))
	  ; assertFalse(GroupD.getPool().get(2).isDeadtie2()); assertFalse(GroupD.getPool().get(3).isDeadtie2());
	  
	  
	  //C(pool) >(pool) A > (pool)D > (pool) B Group GroupE = new
	 Group GroupE = new  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupE.updateMatch("Optic", "Faze", 3, 2);
	  GroupE.updateMatch("Optic","Legion", 2, 3); GroupE.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupE.updateMatch("Optic", "Thieves", 2, 3);
	  GroupE.updateMatch("Optic", "Surge", 3, 0);
	  
	  GroupE.updateMatch("Faze", "Surge", 3, 0); GroupE.updateMatch("Faze",
	  "Legion", 3, 2); GroupE.updateMatch("Faze","Thieves", 3, 2);
	  GroupE.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupE.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupE.updateMatch("Thieves","Legion", 2, 3); GroupE.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupE.updateMatch("Rokkr", "Legion",2, 3);
	  GroupE.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupE.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupE.sortStandings();
	  
	  assertTrue(GroupE.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupE.getPool().get(0).isDeadtie2()); assertFalse(GroupE.getPool().get(1).isDeadtie2());
	  assertTrue(GroupE.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupE.getPool().get(2).isDeadtie2()); assertFalse(GroupE.getPool().get(3).isDeadtie2());
	  
	  
	  //A >(map) C > B (map) D Group GroupF = new
	 Group GroupF = new  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupF.updateMatch("Optic", "Faze", 3, 2);
	  GroupF.updateMatch("Optic","Legion", 0, 3); GroupF.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupF.updateMatch("Optic", "Thieves", 2, 3);
	  GroupF.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupF.updateMatch("Faze", "Surge", 3, 2); GroupF.updateMatch("Faze",
	  "Legion", 3, 2); GroupF.updateMatch("Faze","Thieves", 3, 2);
	  GroupF.updateMatch("Faze", "Rokkr", 0, 3);
	  
	  GroupF.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupF.updateMatch("Thieves","Legion", 2, 3); GroupF.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupF.updateMatch("Rokkr", "Legion",2, 3);
	  GroupF.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupF.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupF.sortStandings();
	  
	  
	  assertTrue(GroupF.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupF.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName()))
	  ; assertFalse(GroupF.getPool().get(0).isDeadtie2()); assertFalse(GroupF.getPool().get(1).isDeadtie2());
	  assertTrue(GroupF.getPool().get(2).getName().equals(GroupA.getPool().get(2).getName()))
	  ;
	  assertTrue(GroupF.getPool().get(3).getName().equals(GroupA.getPool().get(3).getName()))
	  ; assertFalse(GroupF.getPool().get(2).isDeadtie2()); assertFalse(GroupF.getPool().get(3).isDeadtie2());
	  
	  //C>(map) A> D(map) B Group GroupG = new
	  Group GroupG = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupG.updateMatch("Optic", "Faze", 3, 2);
	  GroupG.updateMatch("Optic","Legion", 2, 3); GroupG.updateMatch("Optic",
	  "Rokkr", 3, 0); GroupG.updateMatch("Optic", "Thieves", 2, 3);
	  GroupG.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupG.updateMatch("Faze", "Surge", 3, 2); GroupG.updateMatch("Faze",
	  "Legion", 3, 2); GroupG.updateMatch("Faze","Thieves", 3, 2);
	  GroupG.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupG.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupG.updateMatch("Thieves","Legion", 2, 3); GroupG.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupG.updateMatch("Rokkr", "Legion",2, 3);
	  GroupG.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupG.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupG.sortStandings();
	  
	  
	  assertTrue(GroupG.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupG.getPool().get(0).isDeadtie2()); assertFalse(GroupG.getPool().get(1).isDeadtie2());
	  assertFalse(GroupG.getPool().get(2).isDeadtie2()); assertFalse(GroupG.getPool().get(3).isDeadtie2()); }
	  
	  @Test 
	  public void fourWayBreakTestTwoTwoRecords3() { //A = D > B = C Group GroupA =
		  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",2, 3);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(0).isDeadtie2());
	  assertTrue(GroupA.getPool().get(1).isDeadtie2());
	  assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  
	  
	  //A >(pool) D > B = C Group GroupB = new
	  Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 2, 3);
	  GroupB.updateMatch("Optic","Legion", 2, 3); GroupB.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupB.updateMatch("Optic", "Thieves", 3, 2);
	  GroupB.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupB.updateMatch("Faze", "Surge", 0, 3); GroupB.updateMatch("Faze",
	  "Legion", 3, 2); GroupB.updateMatch("Faze","Thieves", 3, 2);
	  GroupB.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupB.updateMatch("Thieves","Legion", 2, 3); GroupB.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupB.updateMatch("Rokkr", "Legion",2, 3);
	  GroupB.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupB.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupB.sortStandings();
	  
	  
	  assertTrue(GroupB.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupB.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName()))
	  ; assertFalse(GroupB.getPool().get(0).isDeadtie2()); assertFalse(GroupB.getPool().get(1).isDeadtie2());
	  assertTrue(GroupB.getPool().get(2).isDeadtie2());
	  assertTrue(GroupB.getPool().get(3).isDeadtie2());
	  
	  
	  //D(pool) >(pool)A > B = C Group GroupC = new
	  Group GroupC = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupC.updateMatch("Optic", "Faze", 2, 3);
	  GroupC.updateMatch("Optic","Legion", 2, 3); GroupC.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupC.updateMatch("Optic", "Thieves", 3, 2);
	  GroupC.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupC.updateMatch("Faze", "Surge", 2, 3); GroupC.updateMatch("Faze",
	  "Legion", 3, 2); GroupC.updateMatch("Faze","Thieves", 3, 2);
	  GroupC.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupC.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupC.updateMatch("Thieves","Legion", 2, 3); GroupC.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupC.updateMatch("Rokkr", "Legion",2, 3);
	  GroupC.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupC.updateMatch("Legion", "Surge", 0, 3); GroupC.sortStandings();
	  
	  assertTrue(GroupC.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupC.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupC.getPool().get(0).isDeadtie2()); assertFalse(GroupC.getPool().get(1).isDeadtie2());
	  assertTrue(GroupC.getPool().get(2).isDeadtie2());
	  assertTrue(GroupC.getPool().get(3).isDeadtie2());
	  
	  
	  //D(pool) >(pool) A > (pool)B > (pool) C Group GroupD = new
	  Group GroupD = new  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupD.updateMatch("Optic", "Faze", 2, 3);
	  GroupD.updateMatch("Optic","Legion", 2, 3); GroupD.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupD.updateMatch("Optic", "Thieves", 3, 2);
	  GroupD.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupD.updateMatch("Faze", "Surge", 2, 3); GroupD.updateMatch("Faze",
	  "Legion", 3, 2); GroupD.updateMatch("Faze","Thieves", 3, 2);
	  GroupD.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupD.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupD.updateMatch("Thieves","Legion", 2, 3); GroupD.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupD.updateMatch("Rokkr", "Legion",2, 3);
	  GroupD.updateMatch("Rokkr","Surge",3, 0);
	  
	  GroupD.updateMatch("Legion", "Surge", 0, 3);
	  
	  GroupD.sortStandings();
	  
	  assertTrue(GroupD.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupD.getPool().get(0).isDeadtie2()); assertFalse(GroupD.getPool().get(1).isDeadtie2());
	  assertTrue(GroupD.getPool().get(2).getName().equals(GroupA.getPool().get(2).getName()))
	  ;
	  assertTrue(GroupD.getPool().get(3).getName().equals(GroupA.getPool().get(3).getName()))
	  ; assertFalse(GroupD.getPool().get(2).isDeadtie2()); assertFalse(GroupD.getPool().get(3).isDeadtie2());
	  
	  
	  //D(pool) >(pool) A > (pool)C > (pool) B Group GroupE = new
	  Group GroupE = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupE.updateMatch("Optic", "Faze", 2, 3);
	  GroupE.updateMatch("Optic","Legion", 2, 3); GroupE.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupE.updateMatch("Optic", "Thieves", 3, 2);
	  GroupE.updateMatch("Optic", "Surge", 3, 0);
	  
	  GroupE.updateMatch("Faze", "Surge", 2, 3); GroupE.updateMatch("Faze",
	  "Legion", 3, 2); GroupE.updateMatch("Faze","Thieves", 3, 2);
	  GroupE.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupE.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupE.updateMatch("Thieves","Legion", 2, 3); GroupE.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupE.updateMatch("Rokkr", "Legion",2, 3);
	  GroupE.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupE.updateMatch("Legion", "Surge", 0, 3);
	  
	  GroupE.sortStandings();
	  
	  assertTrue(GroupE.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ; assertFalse(GroupE.getPool().get(0).isDeadtie2()); assertFalse(GroupE.getPool().get(1).isDeadtie2());
	  assertTrue(GroupE.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupE.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupE.getPool().get(2).isDeadtie2()); assertFalse(GroupE.getPool().get(3).isDeadtie2());
	  
	  
	  //A >(map) D > B (map) >C Group GroupF = new
	  Group GroupF = new  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  GroupF.updateMatch("Optic", "Faze", 2, 3);
	  GroupF.updateMatch("Optic","Legion", 0, 3); GroupF.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupF.updateMatch("Optic", "Thieves", 3, 2);
	  GroupF.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupF.updateMatch("Faze", "Surge", 2, 3); GroupF.updateMatch("Faze",
	  "Legion", 3, 2); GroupF.updateMatch("Faze","Thieves", 3, 2);
	  GroupF.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupF.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupF.updateMatch("Thieves","Legion", 2, 3); GroupF.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupF.updateMatch("Rokkr", "Legion",2, 3);
	  GroupF.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupF.updateMatch("Legion", "Surge", 2, 3);
	  
	  GroupF.sortStandings();
	  
	  
	  assertTrue(GroupF.getPool().get(0).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupF.getPool().get(1).getName().equals(GroupA.getPool().get(1).getName()))
	  ; assertFalse(GroupF.getPool().get(0).isDeadtie2()); assertFalse(GroupF.getPool().get(1).isDeadtie2());
	  assertTrue(GroupF.getPool().get(2).getName().equals(GroupA.getPool().get(2).getName()))
	  ;
	  assertTrue(GroupF.getPool().get(3).getName().equals(GroupA.getPool().get(3).getName()))
	  ; assertFalse(GroupF.getPool().get(2).isDeadtie2()); assertFalse(GroupF.getPool().get(3).isDeadtie2());
	  
	  //D>(map) A> C(map) B Group GroupG = new
	  Group GroupG = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupG.updateMatch("Optic", "Faze", 2, 3);
	  GroupG.updateMatch("Optic","Legion", 2, 3); GroupG.updateMatch("Optic",
	  "Rokkr", 3, 0); GroupG.updateMatch("Optic", "Thieves", 3, 2);
	  GroupG.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupG.updateMatch("Faze", "Surge", 2, 3); GroupG.updateMatch("Faze",
	  "Legion", 3, 0); GroupG.updateMatch("Faze","Thieves", 3, 2);
	  GroupG.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupG.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupG.updateMatch("Thieves","Legion", 2, 3); GroupG.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupG.updateMatch("Rokkr", "Legion",2, 3);
	  GroupG.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupG.updateMatch("Legion", "Surge", 2, 3); GroupG.sortStandings();
	  
	  
	  assertTrue(GroupG.getPool().get(0).getName().equals(GroupA.getPool().get(1).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(1).getName().equals(GroupA.getPool().get(0).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(2).getName().equals(GroupA.getPool().get(3).getName()))
	  ;
	  assertTrue(GroupG.getPool().get(3).getName().equals(GroupA.getPool().get(2).getName()))
	  ; assertFalse(GroupG.getPool().get(0).isDeadtie2()); assertFalse(GroupG.getPool().get(1).isDeadtie2());
	  assertFalse(GroupG.getPool().get(2).isDeadtie2()); assertFalse(GroupG.getPool().get(3).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void fourWayBreakTestTwoTwoRecords4() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(0).isDeadtie2());
	  assertTrue(GroupA.getPool().get(1).isDeadtie2());
	  assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  
	  Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 2, 3);
	  GroupB.updateMatch("Optic","Legion", 3, 2); GroupB.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupB.updateMatch("Optic", "Thieves", 2, 3);
	  GroupB.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupB.updateMatch("Faze", "Surge", 2, 3); GroupB.updateMatch("Faze",
	  "Legion", 2, 3); GroupB.updateMatch("Faze","Thieves", 3, 2);
	  GroupB.updateMatch("Faze", "Rokkr", 3, 2);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupB.updateMatch("Thieves","Legion", 2, 3); GroupB.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupB.updateMatch("Rokkr", "Legion",3, 2);
	  GroupB.updateMatch("Rokkr","Surge",3,2);
	  
	  GroupB.updateMatch("Legion", "Surge", 3, 2);
	  
	  GroupB.sortStandings(); assertTrue(GroupB.getPool().get(0).isDeadtie2());
	  assertTrue(GroupB.getPool().get(1).isDeadtie2());
	  assertTrue(GroupB.getPool().get(2).isDeadtie2());
	  assertTrue(GroupB.getPool().get(3).isDeadtie2());
	  
	  
	  }
	  
	  
	  @Test 
	  public void threeOHTest1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 2); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",2, 3);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(0).isDeadtie3());
	  assertTrue(GroupA.getPool().get(1).isDeadtie3());
	  assertTrue(GroupA.getPool().get(2).isDeadtie3());
	  assertTrue(GroupA.getPool().get(3).isDeadtie3());
	  
	  
	  Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 2, 3);
	  GroupB.updateMatch("Optic","Legion", 3, 2); GroupB.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupB.updateMatch("Optic", "Thieves", 3, 2);
	  GroupB.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupB.updateMatch("Faze", "Surge", 3, 2); GroupB.updateMatch("Faze",
	  "Legion", 2, 3); GroupB.updateMatch("Faze","Thieves", 3, 2);
	  GroupB.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupB.updateMatch("Thieves","Legion", 2, 3); GroupB.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupB.updateMatch("Rokkr", "Legion",3, 2);
	  GroupB.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupB.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupB.sortStandings(); assertFalse(GroupB.getPool().get(0).isDeadtie3());
	  assertTrue(GroupB.getPool().get(1).isDeadtie3());
	  assertTrue(GroupB.getPool().get(2).isDeadtie3());
	  assertTrue(GroupB.getPool().get(3).isDeadtie3());
	  
	  Group GroupC = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupC.updateMatch("Optic", "Faze", 3, 2);
	  GroupC.updateMatch("Optic","Legion", 3, 2); GroupC.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupC.updateMatch("Optic", "Thieves", 2, 3);
	  GroupC.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupC.updateMatch("Faze", "Surge", 3, 2); GroupC.updateMatch("Faze",
	  "Legion", 3, 2); GroupC.updateMatch("Faze","Thieves", 3, 2);
	  GroupC.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupC.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupC.updateMatch("Thieves","Legion", 2, 3); GroupC.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupC.updateMatch("Rokkr", "Legion",2, 3);
	  GroupC.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupC.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupC.sortStandings(); assertFalse(GroupC.getPool().get(0).isDeadtie3());
	  assertTrue(GroupC.getPool().get(1).isDeadtie3());
	  assertTrue(GroupC.getPool().get(2).isDeadtie3());
	  assertTrue(GroupC.getPool().get(3).isDeadtie3());
	  
	  Group GroupD = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  
	  GroupD.updateMatch("Optic", "Faze", 2, 3);
	  GroupD.updateMatch("Optic","Legion", 2, 3); GroupD.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupD.updateMatch("Optic", "Thieves", 3, 2);
	  GroupD.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupD.updateMatch("Faze", "Surge", 2, 3); GroupD.updateMatch("Faze",
	  "Legion", 3, 2); GroupD.updateMatch("Faze","Thieves", 2, 3);
	  GroupD.updateMatch("Faze", "Rokkr", 3, 2);
	  
	  GroupD.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupD.updateMatch("Thieves","Legion", 2, 3); GroupD.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupD.updateMatch("Rokkr", "Legion",3, 2);
	  GroupD.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupD.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupD.sortStandings(); assertFalse(GroupD.getPool().get(0).isDeadtie3());
	  assertTrue(GroupD.getPool().get(1).isDeadtie3());
	  assertTrue(GroupD.getPool().get(2).isDeadtie3());
	  assertTrue(GroupD.getPool().get(3).isDeadtie3()); }
	  
	  
	  @Test 
	  public void OHthreeTest1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie3());
	  assertTrue(GroupA.getPool().get(3).isDeadtie3());
	  assertTrue(GroupA.getPool().get(4).isDeadtie3()); assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  
	  Group GroupB = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupB.updateMatch("Optic", "Faze", 2, 3);
	  GroupB.updateMatch("Optic","Legion", 3, 2); GroupB.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupB.updateMatch("Optic", "Thieves", 2, 3);
	  GroupB.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupB.updateMatch("Faze", "Surge", 2, 3); GroupB.updateMatch("Faze",
	  "Legion", 2, 3); GroupB.updateMatch("Faze","Thieves", 2, 3);
	  GroupB.updateMatch("Faze", "Rokkr", 3, 2);
	  
	  GroupB.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupB.updateMatch("Thieves","Legion", 3, 2); GroupB.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupB.updateMatch("Rokkr", "Legion",2, 3);
	  GroupB.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupB.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupB.sortStandings(); assertTrue(GroupB.getPool().get(2).isDeadtie3());
	  assertTrue(GroupB.getPool().get(3).isDeadtie3());
	  assertTrue(GroupB.getPool().get(4).isDeadtie3()); assertFalse(GroupB.getPool().get(5).isDeadtie3());
	  
	  Group GroupC = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupC.updateMatch("Optic", "Faze", 2, 3);
	  GroupC.updateMatch("Optic","Legion", 2, 3); GroupC.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupC.updateMatch("Optic", "Thieves", 3, 2);
	  GroupC.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupC.updateMatch("Faze", "Surge", 2, 3); GroupC.updateMatch("Faze",
	  "Legion", 3, 2); GroupC.updateMatch("Faze","Thieves", 2, 3);
	  GroupC.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupC.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupC.updateMatch("Thieves","Legion", 3, 2); GroupC.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupC.updateMatch("Rokkr", "Legion",2, 3);
	  GroupC.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupC.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupC.sortStandings(); assertTrue(GroupC.getPool().get(2).isDeadtie3());
	  assertTrue(GroupC.getPool().get(3).isDeadtie3());
	  assertTrue(GroupC.getPool().get(4).isDeadtie3()); assertFalse(GroupC.getPool().get(5).isDeadtie3());
	  
	  Group GroupD = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  
	  GroupD.updateMatch("Optic", "Faze", 3, 2);
	  GroupD.updateMatch("Optic","Legion", 2, 3); GroupD.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupD.updateMatch("Optic", "Thieves", 2, 3);
	  GroupD.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupD.updateMatch("Faze", "Surge", 3, 2); GroupD.updateMatch("Faze",
	  "Legion", 2, 3); GroupD.updateMatch("Faze","Thieves", 3, 2);
	  GroupD.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupD.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupD.updateMatch("Thieves","Legion", 3, 2); GroupD.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupD.updateMatch("Rokkr", "Legion",3, 2);
	  GroupD.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupD.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupD.sortStandings(); assertTrue(GroupD.getPool().get(2).isDeadtie3());
	  assertTrue(GroupD.getPool().get(3).isDeadtie3());
	  assertTrue(GroupD.getPool().get(4).isDeadtie3()); assertFalse(GroupD.getPool().get(5).isDeadtie3());
	  }
	  
	  @Test 
	  public void OHthreeMapTest1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 0); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie3());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest2() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 0); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie3());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest3() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 0); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2());
	  
	  }
	  
	  @Test  public void OHthreeMapTest4() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 0); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest5() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 0); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest6() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 0); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest7() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest8() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest9() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 1); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 1); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test
	  public void OHthreeMapTest10() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 1); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 1, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 1); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest11() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 0); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreeMapTest12() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 0); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  
	  
	  @Test 
	  public void OHthreePoolTest1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie3());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest2() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",1, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie3());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest3() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie3());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest4() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest5() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 0);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest6() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest7() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",0, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest8() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest9() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void OHthreePoolTest10() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 0, 3);
	  GroupA.updateMatch("Optic", "Surge", 0, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(2).isDeadtie2());
	  assertFalse(GroupA.getPool().get(3).isDeadtie2()); assertFalse(GroupA.getPool().get(4).isDeadtie2());
	  assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(3).isDeadtie3());
	  assertTrue(GroupA.getPool().get(4).isDeadtie3());
	  assertTrue(GroupA.getPool().get(5).isDeadtie3());
	  
	  }
	  
	  @Test
	  public void TheeWayBreak2() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak3() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 1);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak4() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 0, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2());
	  assertTrue(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak5() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 0, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak6() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 0, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak7() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertTrue(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak8() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 1, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 0);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak9() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 1, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 1, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2());
	  assertTrue(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test  public void TheeWayBreak10() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 1, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertTrue(GroupA.getPool().get(4).isDeadtie2());
	  assertTrue(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayBreak11() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 3, 2); GroupA.updateMatch("Optic",
	  "Rokkr", 2, 3); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 1, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 0, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayMapBreak1() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 2); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 2, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayMapBreak2() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 3, 2);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 2, 3);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 2, 3); GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 3, 2);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 2, 3);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); GroupA.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  assertFalse(GroupA.getPool().get(4).isDeadtie2()); assertFalse(GroupA.getPool().get(5).isDeadtie2());
	  
	  }
	  
	  @Test 
	  public void TheeWayMapBreak3() { Group GroupA = new
	  Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 2, 3);
	  GroupA.updateMatch("Optic","Legion", 2, 3); GroupA.updateMatch("Optic",
	  "Rokkr", 3, 2); GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 2, 3); GroupA.updateMatch("Faze",
	  "Legion", 3, 2); GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); GroupA.updateMatch("Thieves",
	  "Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 2, 3);
	  
	  
	  GroupA.sortStandings(); assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  
	  }
	  @Test 
	  public void twoWayTie() { 
		  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 3, 2);
	  GroupA.updateMatch("Optic","Legion", 3, 2); 
	  GroupA.updateMatch("Optic", "Rokkr", 3, 2); 
	  GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 2, 3);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 2); 
	  GroupA.updateMatch("Faze","Legion", 3, 2); 
	  GroupA.updateMatch("Faze","Thieves", 3, 2);
	  GroupA.updateMatch("Faze", "Rokkr", 3, 2);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 3, 2); 
	  GroupA.updateMatch("Thieves","Surge", 3, 2);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",3, 2);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings();
	  //GroupA.printStandings(false,GroupA.getPool());
	  //assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  
	  }
	  @Test 
	  public void fivewaytieFiveZero() { 
		  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
	  
	  GroupA.updateMatch("Optic", "Faze", 3, 1);
	  GroupA.updateMatch("Optic","Legion", 3, 0); 
	  GroupA.updateMatch("Optic", "Rokkr", 3, 2); 
	  GroupA.updateMatch("Optic", "Thieves", 3, 2);
	  GroupA.updateMatch("Optic", "Surge", 3, 2);
	  
	  GroupA.updateMatch("Faze", "Surge", 3, 1); 
	  GroupA.updateMatch("Faze","Legion", 3, 2); 
	  GroupA.updateMatch("Faze","Thieves", 2, 3);
	  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
	  
	  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
	  GroupA.updateMatch("Thieves","Legion", 2, 3); 
	  GroupA.updateMatch("Thieves","Surge", 1, 3);
	  
	  GroupA.updateMatch("Rokkr", "Legion",3, 2);
	  GroupA.updateMatch("Rokkr","Surge",2, 3);
	  
	  GroupA.updateMatch("Legion", "Surge", 3, 2);
	  
	  
	  GroupA.sortStandings();
	  GroupA.printStandings(false,GroupA.getPool());
	  //assertFalse(GroupA.getPool().get(3).isDeadtie2());
	  
	  }
	  @Test 
	  public void fivewaytieZeroFive() { 
		  Group GroupA = new Group("Faze","Optic","Thieves","Rokkr","Legion", "Surge");
		  
		  GroupA.updateMatch("Optic", "Faze", 2, 3);
		  GroupA.updateMatch("Optic","Legion", 2, 3); 
		  GroupA.updateMatch("Optic", "Rokkr", 2, 3); 
		  GroupA.updateMatch("Optic", "Thieves", 2, 3);
		  GroupA.updateMatch("Optic", "Surge", 2, 3);
		  
		  GroupA.updateMatch("Faze", "Surge", 3, 1); 
		  GroupA.updateMatch("Faze","Legion", 3, 2); 
		  GroupA.updateMatch("Faze","Thieves", 0, 3);
		  GroupA.updateMatch("Faze", "Rokkr", 2, 3);
		  
		  GroupA.updateMatch("Thieves", "Rokkr", 3, 2);
		  GroupA.updateMatch("Thieves","Legion", 2, 3); 
		  GroupA.updateMatch("Thieves","Surge", 1, 3);
		  
		  GroupA.updateMatch("Rokkr", "Legion",3, 2);
		  GroupA.updateMatch("Rokkr","Surge",2, 3);
		  
		  GroupA.updateMatch("Legion", "Surge", 3, 2);
		  
		  
		  GroupA.sortStandings();
		  GroupA.printStandings(false,GroupA.getPool());
	  }
	 }
