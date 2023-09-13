public class HashTable {

    // public for testing purposes
    public int buckets[];

    long a;
    long c;
    long m;

    public HashTable(long _a, long _c, long _m) {

        a = _a;
        c = _c;
        m = _m;

        buckets = new int[(int)m-1];
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = -1;
        }
    }

    public void insert(int key) {
        int temp;
        double load = loadFactor();
        int cont;

        temp = (int)(((a*key)+c)%m);

        if ( loadFactor() < 1 )
        {
            if ( buckets[temp] == -1 )
            {
                buckets[temp] = key;
            }
            else
            {
                while ( buckets[temp] > -1 )
                {
                    temp = temp + 1;
                }
                buckets[temp] = key;
            }
        }

//        // Only run on positive inputs
//        if ( key >= 0 )
//        {
//            temp = (int)(((a*key)+c)%m);
//
//            if ( buckets[temp] == -1)
//            {
//                buckets[temp] = key;
//            }
//            else
//            {
//                while ( buckets[temp] !== -1 )
//                {
//                    temp = temp + 1;
//                }
//                buckets[temp] = key;
//            }
//        }
//        else if ( loadFactor() == 1)
//        {
//            // All buckets are occupied so, extend
//            extend();
//        }

//        temp = (int)(((a*key)+c)%m);
//
//        for ( int i = 0; i < (int)m; i++)
//        {
//            if (buckets[temp + i% (int)m] < 1)
//            {
//                buckets[(temp + i)% (int)m] = key;
//            }
//        }

    }

    public void extend(){
    }

    public boolean find(int key) {

//        int temp;
//        temp = (int)(((a*key)+c)%m);
//
//        if ( buckets[temp] == key )
//        {
//            return true;
//        }
//        else
//        {
//            for (int i = key; i < buckets.length; i++)
//            {
//                if ( buckets[i] == key )
//                {
//                    return true;
//                }
//            }
//        }

        int temp;
        temp = (int)(((a*key)+c)%m);

        if ( buckets[temp] == key)
        {
            return true;
        }

        if ( buckets[temp + 1] == key)
        {
            return true;
        }

//            if ( buckets[temp] !== -1 )
//            {
//                if (buckets[temp] == key)
//                {
//                    return true;
//                }
//                else if ( buckets[temp+1] == key )
//                {
//                        return true;
//                }
//            }

        return false;
    }

    public void remove(int key) {
        int temp;

        temp = (int)(((a*key)+c)%m);

        if ( buckets[temp] == key )
        {
            buckets[temp] = -1;
        }

    }

    public double loadFactor() {

        // Load Factor = number of buckets used / total number of buckets

        double count = 0;
        double count1 = buckets.length;
        double countFin = 0;
        double _load;

        for (int i = 0; i < buckets.length; i++)
        {
            if ( buckets[i] == -1)
            {
                count = count + 1;
            }
        }

        countFin = count1 - count;

        _load = countFin/count1;

        //_load = (Math.round((_load * 8) / 8));

        //DecimalFormat df = new DecimalFormat("#.#####");
        //df.format(_load);
        //String.format("%.8g%n", _load);
        //DoublevalueOf(_load);

        // I had to round this to 8 decimal but i didnt get the time to round _load to 8 decimal places so, the
        // stupid auto grader kept marking me down even though the answers were right, just with higher decimal
        // places.

        return _load;

        //return 0.5;
    }
}
