class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        vector<int> cGas = gas, gCost = cost;
        cGas.insert(cGas.end(), gas.begin(), gas.end());
        gCost.insert(gCost.end(), cost.begin(), cost.end());

        int sum=0, st=0;

        for(int i=0;i<cGas.size();i++) {
            sum += cGas[i]-gCost[i];
            while(sum<0) {
                sum -= cGas[st]-gCost[st];
                st++;
            }
            if(sum>=0 && i-st+1==gas.size()) return st;
        }
        return -1;
    }
};
