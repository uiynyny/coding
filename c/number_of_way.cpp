#include <iostream>

using namespace std;
int countway(int d)
{
    int dp[d+1];
    dp[0]=1;
    dp[1]=1;
    dp[2]=2;
    for(int i=3;i<=d;i++){
        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    }
    return dp[d];
}
int main()
{
    int dist = 4;
    cout << countway(dist);
    return 0;
}