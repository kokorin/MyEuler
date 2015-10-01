package problem.h000.d050;

import problem.Problem;
import util.Primes;

/**
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 * <p>
 * <table>
 * <tr><td>37</td><td>36</td><td>35</td><td>34</td><td>33</td><td>32</td><td>31</td></tr>
 * <tr><td>38</td><td>17</td><td>16</td><td>15</td><td>14</td><td>13</td><td>30</td></tr>
 * <tr><td>39</td><td>18</td> <td>5</td> <td>4</td> <td>3</td><td>12</td><td>29</td></tr>
 * <tr><td>40</td><td>19</td> <td>6</td> <td>1</td> <td>2</td><td>11</td><td>28</td></tr>
 * <tr><td>41</td><td>20</td> <td>7</td> <td>8</td> <td>9</td><td>10</td><td>27</td></tr>
 * <tr><td>42</td><td>21</td><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td></tr>
 * <tr><td>43</td><td>44</td><td>45</td><td>46</td><td>47</td><td>48</td><td>49</td></tr>
 * </table>
 * <p>
 * <p>
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting
 * is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 * <p>
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 * If this process is continued, what is the side length of the square spiral for which the ratio of primes along
 * both diagonals first falls below 10%?
 */
public class Problem058 implements Problem{
    @Override
    public long solve() {
        long totalPrimes = 0;

        long topRight = 1;
        long topLeft = 1;
        long bottomLeft = 1;
        long bottomRight = 1;

        for (long n = 1; ; n++) {
            topRight = bottomRight + 2 * n;
            topLeft = topRight + 2 * n;
            bottomLeft = topLeft + 2 * n;
            bottomRight = bottomLeft + 2 * n;

            if (Primes.isPrime(topRight)) {
                totalPrimes++;
            }
            if (Primes.isPrime(topLeft)) {
                totalPrimes++;
            }
            if (Primes.isPrime(bottomLeft)) {
                totalPrimes++;
            }
            if (Primes.isPrime(bottomRight)) {
                totalPrimes++;
            }

            if ((10 * totalPrimes) < (4 * n + 1)) {
                return 2 * n + 1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Problem058().solve());
    }
}
