#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define int ll
void start() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

}
set<string>answer;
vector<bool>flag(15,false);


void backTracking(vector<int>&v, int l, int r , int x, vector<int>&p,int sum , int mi , int mx){

    if(v.size()>=2&&sum>=l&&sum<=r&&mx-mi>=x){
        set<int>s;
        for(auto it:v)s.insert(it);
        stringstream ss ;
        for(auto it : s)ss<<it;
        answer.insert(ss.str());

    } else {
        if(v.size()>=2&&sum>r) return;
    }
    for(int i=0;i<p.size();i++){
        if(flag[i]) continue;
        flag[i]=true;
        v.push_back(i);
        backTracking(v,l,r,x,p,sum+p[i],min(mi,p[i]),max(mx,p[i]));
        v.pop_back();
        flag[i]= false;
    }



}








signed  main() {
start();
int n , l , r , x ;cin>>n>>l>>r>>x;
vector<int>v(n),t;
    for (int i = 0; i < n; ++i) {
        cin>>v[i];
    }
    backTracking(t,l,r,x,v,0,INT64_MAX,0);
   cout<<answer.size();









    }




























