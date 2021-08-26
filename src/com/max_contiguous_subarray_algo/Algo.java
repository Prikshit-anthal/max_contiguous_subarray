package com.max_contiguous_subarray_algo;

class imple{
	int[] a;
	int l,m,r,MIN=-999999;
	
	imple(int [] b)
	{
		a=b;
		l=0;
		r=a.length-1;
		m=(l+r)/2;
		int [] l=max_subarray(0,r);
		System.out.println(l[0]+" "+l[1]+" "+l[2]);
		
	}
	int [] max_cross_subarray(int l1,int m1,int r1)
	{
		int [] p=new int[3];
		int left_min=MIN;
		int sum=0;
		for(int i=m1;i>=l1;i--)
		{
			sum+=a[i];
			if(sum>left_min)
			{
				left_min=sum;
				p[0]=i;
			}
			
		}
		sum=0;
		int right_min=MIN;
		for(int i=m1+1;i<=r1;i++)
		{
			sum+=a[i];
			if(sum>right_min)
			{
				right_min=sum;
				p[1]=i;
			}
		}
		p[2]=left_min+right_min;
		return(p);
		
		
	}
	
	int [] max_subarray(int l1, int r1)
	{
		int [] p=new int[3];
		if(l1==r1)
			{
			p[0]=l1;p[1]=l1;p[2]=a[l1];
			return(p);
			}
	int	m1=(l1+r1)/2;
	int [] p1=max_subarray(l1,m1);
	int [] p2=max_subarray(m1+1,r1);
	int [] p3=max_cross_subarray(l1,m1,r1);
	if(p1[2]>=p2[2]&&p1[2]>=p3[2])
	{
		p[0]=p1[0];
		p[1]=p1[1];
		p[2]=p1[2];
	}
	else if(p2[2]>=p1[2]&&p2[2]>=p3[2])
	{
		p[0]=p2[0];
		p[1]=p2[1];
		p[2]=p2[2];
	}
	else
	{
		p[0]=p3[0];
		p[1]=p3[1];
		p[2]=p3[2];
		
	}
	return(p);
}

}
 class Algo {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		int [] a=new int[]{100 ,113, 110, 85, 105, 102, 86, 63 ,81 ,101, 94 ,106, 101 ,79 ,94 ,90 ,97};
        int [] diff_arr=new int[a.length-1];
		for(int i=1;i<a.length;i++ )
		{
			diff_arr[i-1]=a[i]-a[i-1];
		}
		 
		imple obj=new imple(diff_arr);
		
    
	}

}
