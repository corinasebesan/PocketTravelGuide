package com.example.cory4.pockettravelguide;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Route {
    public void Route(){}
    public ArrayList backpack(int nrObi, int hDisp, int[] hObi, int[] impObi){
        //ghiozdan
        int[][] B = new int[nrObi + 1][ hDisp + 1];

        for (int i = 1; i <= nrObi; i++)
        {
            for (int j = 0; j <= hDisp; j++)
            {
                if (hObi[i] <= j)
                {
                    if (impObi[i] + B[i - 1][ j - hObi[i]] > B[i - 1][ j])
                    {
                        B[i][ j] = impObi[i] + B[i - 1][ j - hObi[i]];

                    }
                        else
                    B[i][ j] = B[i - 1][ j];

                }

                else B[i][ j] = B[i - 1][ j];

            }
        }
        //ghiozdanul optimal ar trebui sa contina
        int m = nrObi;
        int o = hDisp;
        ArrayList opt=new ArrayList();
        while(m>0&&o>0)
        {

            if (B[m][o] != B[m - 1][o])
            {
                opt.add(m);
                m = m - 1;
                o = o - hObi[m];
            }
            else { m = m - 1; }

        }
        return opt;

    }
}
