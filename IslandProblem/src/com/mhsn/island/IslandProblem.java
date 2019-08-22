package com.mhsn.island;

/*To solve this problem we use DFS using recursion*/
public class IslandProblem {

	private static void countAndFindMaxIsland(int[][] grid){
		int countRegion =0;// number of island
		int maxSize = 0; // largest island of region
		System.out.println("Grid length : "+grid.length);
		
		// iterating 2d grid 
		for(int r = 0; r < grid.length; r++){
			for(int c = 0; c < grid[r].length; c++ ){
				
				if(grid[r][c] != 0 || grid[r][c] != 2  ){// if grid value is 1 
					int size = callDFS(grid, r, c);
					if(size > 0){
						countRegion++; // counting region 
					}
					
					maxSize = Math.max(size, maxSize); // max region
				}
					
			}
			
		}
			
		System.out.println("Total reigon : "+ countRegion);
		System.out.println("Max size : "+ maxSize);
	}
	
	
	private static int callDFS(int[][] grid, int row, int column){
		
		// boundary scenarios
		if(row < 0 || column < 0 || row >= grid.length || column >= grid[0].length ){
			return 0;
		}
		
		if(grid[row][column] == 2 || grid[row][column] == 0){
			return 0;
		}
		
		int size = 1; 
		grid[row][column] = 2; // updating value to 2 to indicate the element is already visited
		for(int r = row-1; r <= row+1; r++){ // visiting adjacent elements of an element
			for(int c = column -1; c<= column+1; c++){
				size += callDFS(grid, r, c);
			}
		}
				
		return size; // size of the island
	}
	
	
	
	
	
	public static void main(String[] args) {
		int [][] grid = new int[][] {
				{0,0,0,1,1,0,0},
				{0,1,0,0,1,1,0},
				{1,1,0,1,0,0,1},
				{0,0,0,0,0,1,0},
				{1,1,0,0,0,0,0},
				{0,0,0,1,0,0,0}
			};
		// island problem : find biggest island
		// count number of island
		countAndFindMaxIsland(grid);
	}
	
	
}
