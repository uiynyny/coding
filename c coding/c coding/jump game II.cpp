//
//  jump game II.cpp
//  c coding
//
//  Created by Yan Zhang on 2020-07-19.
//  Copyright © 2020 Yan Zhang. All rights reserved.
//
#include <vector>
#include <queue>
#include <utility>

class Solution {
public:
    int jump(std::vector<int>& nums) {
        std::queue<std::pair<int,int>> q;
        q.push(std::make_pair(0,0));
        int reachable=0;
        while(!q.empty()){
            auto u=q.front(); q.pop();
            if(u.first==nums.size()-1) return u.second;
            for(int i=reachable-u.first+1;i<nums[u.first]+1 && i<(nums.size()-u.first); i++){
                q.push(std::make_pair(u.first+i,u.second+1));
                reachable=u.first+i;
            }
        }
        return -1;
    }
};

//int main(){
//    std::vector<int> v= {5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
//    Solution* s=new Solution();
//    s->jump(v);
//}
