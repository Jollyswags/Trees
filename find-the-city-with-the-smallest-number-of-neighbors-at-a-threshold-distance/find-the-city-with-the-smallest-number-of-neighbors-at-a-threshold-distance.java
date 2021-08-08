class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        //Block1: Create floyd warshall distance matrix--------------------------------------------
        int[][] dMap =  new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j){
                    dMap[i][j] = 0;
                }else{
                    dMap[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int[] edge: edges){
            dMap[edge[0]][edge[1]] = edge[2];
            dMap[edge[1]][edge[0]] = edge[2];
        }
        //----------------------------------------------------------------------------------------------
		
        
        //Blcok 2: Run Floyd Warshall over matrix******************************************************
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dMap[i][k] != Integer.MAX_VALUE && dMap[k][j] != Integer.MAX_VALUE){
                        dMap[i][j] = Math.min(dMap[i][j], dMap[i][k] + dMap[k][j]);
                    }
                }
            }
        }
        //***********************************************************************************************
        
        
        //Block 3: Calculate cities can be travelled by each city with threshold distance----------------------
        int[] citiesTravelled = new int[n];
        
        for(int i=0;i<n;i++){
            int validCities = 0;
            for(int j=0;j<n;j++){
                validCities += (dMap[i][j] <= distanceThreshold && dMap[i][j] != 0) ? 1 : 0;
            }
            citiesTravelled[i] = validCities;
        }
        //---------------------------------------------------------------------------------------------------------
        
        //Block 4: Calcuate city with minimum neighbouring cities and max number********************************
        int minCityNum = 0;
        int minCityNeiCount = citiesTravelled[minCityNum];
        
        for(int i=1;i<n;i++){
            if(citiesTravelled[i] < minCityNeiCount){
                minCityNeiCount = citiesTravelled[i];
            }
            if(citiesTravelled[i] <= minCityNeiCount){
                minCityNum = i;
                continue;
            }
        }
        //**********************************************************************************************************
        
        // Block 3 && 4 can be combined into a single block
        return minCityNum;
        
    }
}