package followPath;

import ilist.IList;
import java.util.Random;
import gridMap.GridMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import robotSearches.Coordinate;
import robotSearches.Node;
import rp.robotics.mapping.IGridMap;
import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;

/**
 * Runs tests on our implementation for robotics ex4 part 1.2
 * 
 * @author Kyle-Allen Taylor
 *
 */
public class FindPathTest {
	
  @Test
  public void getPath() {
	  RPLineMap lineMap = MapUtils.create2015Map1();
		int xJunctions = 14;
		int yJunctions = 8;
		float junctionSeparation = 30;
		int xInset = 15;
		int yInset = 15;
		
		IGridMap gridMap = new GridMap(xJunctions, yJunctions, xInset, yInset, junctionSeparation,lineMap);		
			  
		FindPath find = new FindPath(gridMap);
	
		for (int i = 0; i < 10; i++) {
			Random random = new Random();
		  
			int startingX = random.nextInt(12);
			int startingY = random.nextInt(8);
			while(gridMap.isObstructed(startingX, startingY)) {
				startingX = random.nextInt(12);
				startingY = random.nextInt(8);
			}
			
			int finishingX = random.nextInt(12);
			int finishingY = random.nextInt(8);
			
			while(gridMap.isObstructed(startingX, startingY)) {
				finishingX = random.nextInt(12);
				finishingY = random.nextInt(8);
			}
		  
			IList<Node<Coordinate>> path = find.getPath(new Coordinate(startingX, startingY), new Coordinate(finishingX, finishingY));
			Node<Coordinate> head = path.head();
			path = path.tail();
			Node<Coordinate> next = path.head();
			
			Assert.assertEquals(gridMap.isValidTransition(head.contents().x(),head.contents().y(), next.contents().x(), next.contents().y()), true);
			
			while (path.size() > 1) {
				head = next;
				next = path.head();
				path = path.tail();
				
				if(path.size() == 2) {
					Assert.assertEquals((finishingX==next.contents().x() && finishingY==next.contents().y()), true);
				}
				
				Assert.assertEquals(gridMap.isValidTransition(head.contents().x(),head.contents().y(), next.contents().x(), next.contents().y()), true);
			}		  
		}	  
  	}  
}