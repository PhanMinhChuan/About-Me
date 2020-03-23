#include <iostream>
#include <fstream>
#include <iomanip>
#include <io.h>
#include <fcntl.h>
#define M 30
#define N 250
using namespace std;
// Ham the hien pp don dinh
void simplexMin(int m, int n, double eps, double gz, double s[M + 1][N + 1] ,int viTri[],int check1, int countTrung) {
	int i, j;				//Bien Dem 
	int k, l;				//Cot quay va dong quay
	int count = 0;			//Buoc lap
	int  vn;				//Check vo nghiem
	int ii[M + 1];			//Chuoi chua cac gia tri co so
	double val;				//Gia tri ham muc tieu
	double te, r;			//Bien trung gian
	double x[N + M + 1];	//Chua cac phuong an toi uu
	//Bang xuat phat: bien co so gom cac bien gia tao, ham muc tieu, cac uoc luong
	if (check1 == 3) {
		for (i = 1; i <= n; i++) {
			ii[i] = viTri[i];
	    }
	} else if (check1 == 4) {
		for (i = 1; i <= m; i++) {		// =2
			ii[i] = n + countTrung + i;
	    }
	} else {
		for (i = 1; i <= m; i++) {
			ii[i] = n + i;
	    }
	}
	for (j = 0; j <= n; j++) {
		r = 0;
		for (i = 1; i <= m; i++) {
			r += s[i][j];				//Zij
		}
		s[0][j] = gz * r - s[0][j];		//Cong thuc tinh cac uoc luong : delta J
	}
	// Buoc lap cua phuong phap don hinh
	bool check = true;
	while (check) {
		count = count + 1;
		cout << "\n====Buoc lap " << count << "  cx= " << s[0][0] << endl;
		cout << "Bang don hinh:" << endl;
		for (i = 0; i <= m; i++) {
			cout << "  Dong  " << i << " : ";
			for (j = 0; j <= n; j++) { 
				cout << s[i][j] << "  ";
			} 
			cout << "\n";
		}

		cout << " Bien co so : ";
		for (i = 1; i <= m; i++) cout << ii[i] << "  ";
		//Tim cot quay, tim max cac uoc luong
		k = 1; r = s[0][1];
		for (j = 2; j <= n; j++) {
			if (s[0][j] > r) {
			k = j;
			r = s[0][j];
			}
		}

		cout << "\n Cot quay = " << k << ",   max delta = " << r << endl;
		// Kiem tra tieu chuan toi uu
		if (r < eps) {
			for (j = 1; j <= n + m; j++) { 
				x[j] = 0;
			}
			for (i = 1; i <= m; i++) { 
				x[ii[i]] = s[i][0];
			}
			val = s[0][0];
			check = false;
		}
		// Chon dong quay
		l = 0; te = 1.0e+30;
		for (i = 1; i <= m; i++) {
			if (s[i][k] > eps) {
				r = s[i][0] / s[i][k];
				if (r < te) {
					l = i;
					te = r;
				}
			}
		}
		cout << "Dong quay = " << l << ", Min = " << te << endl;
		if (l == 0) {
			cout << "Ham muc tieu khong bi chan duoi" << endl; break;
		}
		//Bien doi bang don hinh =>> Ap dung CT tu giac
		r = 1.0 / s[l][k];
		for (j = 0; j <= n; j++) { 
			s[l][j] *= r;				//tinh dong quay
		}	
		for (i = 0; i <= m; i++) {
			if (i != l) {
				r = s[i][k];
				for (j = 0; j <= n; j++) {
					s[i][j] = s[i][j] - s[l][j] * r;
				}
			}
		}
		ii[l] = k;
		system("pause");
	} //ket thuc while
	//Kiem tra bai toan vo nghiem
	vn = 0;
	for (j = n + 1; j <= n + m; j++) {
		if (x[j] > eps) {
			vn = 1;
		}
	}
	//check
	if (vn == 0) {
		cout << "\n==== Nghiem toi uu la: " << endl;
		for (j = 1; j <= n; j++) if (x[j] > eps || x[j] == 0) { 
			cout << "x(" << j << ") = " << x[j] << endl;
		}
		cout << "Tri so nho nhat ham muc tieu: " << val << endl;
		cout << "So buoc lap    : " << count << endl;
		cout << "Chuong Trinh Ket Thuc!!!" << endl;
	} else { 
		cout << "bai toan vo nghiem" << endl;
		cout << "Chuong Trinh Ket Thuc!!!" << endl;
	}
	system("pause");
}

// Ham the hien pp don dinh
void simplexMax(int m, int n, double eps, double gz, double s[M + 1][N + 1] ,int viTri[],int check1, int countTrung) {
	int i, j;				//Bien Dem 
	int k, l;				//Cot quay va dong quay
	int count = 0;			//Buoc lap
	int  vn;				//Check vo nghiem
	int ii[M + 1];			//Chuoi chua cac gia tri co so
	double val;				//Gia tri ham muc tieu
	double te, r;			//Bien trung gian
	double x[N + M + 1];	//Chua cac phuong an toi uu
	//Bang xuat phat: bien co so gom cac bien gia tao, ham muc tieu, cac uoc luong
	if (check1 == 3) {
		for (i = 1; i <= n; i++) {
			ii[i] = viTri[i];
	    }
	} else if (check1 == 4) {
		for (i = 1; i <= m; i++) {		// =2
			ii[i] = n + countTrung + i;
	    }
	} else {
		for (i = 1; i <= m; i++) {
			ii[i] = n + i;
	    }
	}
	for (j = 0; j <= n; j++) {
		r = 0;
		for (i = 1; i <= m; i++) {
			r += s[i][j];				//Zij
		}
		s[0][j] =  -gz * r - s[0][j];		//Cong thuc tinh cac uoc luong : delta J
	}
	// Buoc lap cua phuong phap don hinh
	bool check = true;
	while (check) {
		count = count + 1;
		cout << "\n====Buoc lap " << count << "  cx= " << s[0][0] << endl;
		cout << "Bang don hinh:" << endl;
		for (i = 0; i <= m; i++) {
			cout << "  Dong  " << i << " : ";
			for (j = 0; j <= n; j++) { 
				cout << s[i][j] << "  ";
			} 
			cout << "\n";
		}

		cout << " Bien co so : ";
		for (i = 1; i <= m; i++) cout << ii[i] << "  ";
		//Tim cot quay, tim max cac uoc luong
		k = 1; r = s[0][1];
		for (j = 2; j <= n; j++) {
			if (s[0][j] < r) {
			k = j;
			r = s[0][j];
			}
		}

		cout << "\n Cot quay = " << k << ",   min delta = " << r << endl;
		// Kiem tra tieu chuan toi uu
		if (r > -eps) {
			for (j = 1; j <= n + m; j++) { 
				x[j] = 0;
			}
			for (i = 1; i <= m; i++) { 
				x[ii[i]] = s[i][0];
			}
			val = s[0][0];
			check = false;
		}
		// Chon dong quay
		l = 0; te = 1.0e+30;
		for (i = 1; i <= m; i++) {
			if (s[i][k] > -eps) {
				r = s[i][0] / s[i][k];
				if (r < te) {
					l = i;
					te = r;
				}
			}
		}
		cout << " Dong quay = " << l << ", Min = " << te << endl;
		if (l == 0) {
			cout << "Ham muc tieu khong bi chan duoi" << endl; break;
		}
		//Bien doi bang don hinh =>> Ap dung CT tu giac
		r = 1.0 / s[l][k];
		for (j = 0; j <= n; j++) { 
			s[l][j]= s[l][j] *r;				//tinh dong quay
		}	
		for (i = 0; i <= m; i++) {
			if (i != l) {
				r = s[i][k];
				for (j = 0; j <= n; j++) {
					s[i][j] = (s[i][j] - s[l][j] * r);
				}
			}
		}
		ii[l] = k;
		system("pause");
	} //ket thuc while
	//Kiem tra bai toan vo nghiem
	vn = 0;
	for (j = n + 1; j <= n + m; j++) {
		if (x[j] < -eps) {
			vn = 1;
		}
	}
	//check
	if (vn == 0) {
		cout << "\n==== Nghiem toi uu la: " << endl;
		for (j = 1; j <= n; j++) if (x[j] > eps || x[j] == 0) { 
			cout << "x(" << j << ") = " << x[j] << endl;
		}
		cout << "Tri so lon nhat ham muc tieu: " << val << endl;
		cout << "So buoc lap    : " << count << endl;
		cout << "Chuong Trinh Ket Thuc!!!" << endl;
	} else { 
		cout << "bai toan vo nghiem" << endl;
		cout << "Chuong Trinh Ket Thuc!!!" << endl;
	}
	system("pause");
}

// Chuong trinh chinh: nhap du lieu, goi ham
int main() {
	int m, n, i, j;
	double s[M + 1][N + 1], eps, gz;
	ifstream tep1;
	tep1.open("donhinhvd8.cpp");
	tep1 >> m >> n >> eps >> gz;
	for (i = 0; i <= m; i++) {
		for (j = 0; j <= n; j++) {
			tep1 >> s[i][j]; 
		}
	}
	tep1.close();
	int viTri[n + 1];
	int check1 = 0;
	int check2 = 0;
	int check3 = 0;
	int checkTrung = 0;
	//cout << endl << setw(105) <<">>>>>>>> Nhan 1 TH: CHINH TAC; 2 TH: CHUAN TAC; 3 TH: CHINH TAC CHUAN; 4 TH: TONG QUAT <<<<<<<<" << endl;
	//cout << "Your Choose?: ";
	cout << setw(67) << ">>>>>>>>>>>>>>>> MENU <<<<<<<<<<<<<<<<" << endl;
	cout << setw(55) << "Case 1: CHINH TAC" << endl;
	cout << setw(55) << "Case 2: CHUAN TAC" << endl;
	cout << setw(61) << "Case 3: CHINH TAC CHUAN" << endl;
	cout << setw(55) << "Case 4: TONG QUAT" << endl;
	cout << "Your Choose?: ";
	cin >> check1;
	if (check1 > 4 || check1 < 0) {
			printf("Err: Co loi khi nhap du lieu chon MENU!!!");
			return 0;
		}
	cout << setw(70) << ">>>>>>>> Case 1: MAX; Case 2: MIN <<<<<<<<" << endl;
	cout << "Your Choose?: ";
	cin >> check3;
	if (check1 == 1) {
		//In du lieu de kiem tra
		cout << "-----------Du Lieu Va Bang Don Hinh:-----------"<< endl <<"m,n,ep,gz = " << m << "   " << n << "  " << eps << "   " << gz << endl;
		for (i = 0; i <= m; i++) {
			cout << "Dong " << i << ": ";
			for (j = 0; j <= n; j++) {
				cout << s[i][j] << "  ";
			}
			cout << endl;
	    }
	    if(check3 == 1) {
	    	simplexMax(m, n, eps, gz, s, viTri, check1, checkTrung);
		} else if (check3 ==2) {
			simplexMin(m, n, eps, gz, s, viTri, check1, checkTrung);
		}
   } else if (check1 == 2) {
   		if (check3 != 1 && check3 != 2) {
			printf("Err: Co loi khi nhap du lieu chon min max!!!");
			return 0;
		}
   		cout << setw(80) << ">>>>>>>> Nhan 1 TH: Ax <= B; 2 voi TH: Ax >= B <<<<<<<< " << endl;
		cout << "Your Choose?: ";
   		cin >> check2;
   		cout << endl;
   		int nNew = n + m;	//3 + 3 = 6
   		int hangNew = m +1;	// 3 + 1 = 4
   		double sNew[hangNew][m];	//[4][3]
   		if (check2 == 1) {
	   		for (i = 0; i < hangNew; i++) {		//4
			   for (j = 0; j < m; j++) {	//3
					sNew[i][j] = 0;
					if (j == i - 1 && i != 0) {
						sNew[i][j] = 1;
					} else {
						sNew[i][j] = 0;
					}
			   }
		    }
		} else if (check2 == 2) {
			for (i = 0; i <= hangNew; i++) {
			   for (j = 0; j <= m; j++) {
					sNew[i][j] = 0;
					if (j == i - 1 && i != 0) {
						sNew[i][j] = -1;
					} else {
						sNew[i][j] = 0;
					}
			   }
		    }
		} else {
			printf("Err: Co loi khi nhap du lieu!");
			return 0;
		}
	    for (i = 0; i <= m; i++) {
			for (j = n+1; j <= nNew; j++) {
				s[i][j] = sNew[i][j-(n+1)]; 
			}
		}
		cout << "-----------Du Lieu Va Bang Don Hinh:-----------"<< endl << "m,n,ep,gz = " << m << "   " << nNew << "  " << eps << "   " << gz << endl;
		for (i = 0; i <= m; i++) {
			cout << "Dong " << i << ": ";
			for (j = 0; j <= nNew; j++) {
				cout << s[i][j] << "  ";
			}
			cout << endl;
	    }
	    if(check3 == 1) {
	    	simplexMax(m, nNew, eps, gz, s, viTri, check1, checkTrung);
		} else if (check3 ==2) {
			simplexMin(m, nNew, eps, gz, s, viTri, check1, checkTrung);
		}
		return 0;
   } else if (check1 == 3) {
   		if (check3 != 1 && check3 != 2) {
			printf("Err: Co loi khi nhap du lieu chon min max!!!");
			return 0;
		}
   		cout << setw(75) << ">>>>>>>> Nhap Vi Tri Cua Matrix DON VI <<<<<<<" << endl;
	    for (i = 1; i <= m; i++) {
			cout <<"Vi Tri " << i << ": ";
			cin >> viTri[i];
	    }
	    for (i = 1; i < m; i++) {
			for(int j = i +1; j <= m; j++) {
				if (viTri[i] == viTri[j]) {
					checkTrung++;
				}
			}
	    }
	    if (checkTrung > 0) {
	    	cout << "Err: Co loi luc nhap vi tri!" << endl;
	    	return 0;
		}
   		//In du lieu de kiem tra
		cout << "-----------Du Lieu Va Bang Don Hinh:-----------"<< endl <<"m,n,ep,gz = " << m << "   " << n << "  " << eps << "   " << gz << endl;
		for (i = 0; i <= m; i++) {
			cout << "Dong " << i << ": ";
			for (j = 0; j <= n; j++) {
				cout << s[i][j] << "  ";
			}
			cout << endl;
	    }
	    if(check3 == 1) {
	    	simplexMax(m, n, eps, gz, s, viTri, check1, checkTrung);
		} else if (check3 ==2) {
			simplexMin(m, n, eps, gz, s, viTri, check1, checkTrung);
		}
   } else if (check1 == 4) {
   		int countTrung = 0;
   		int viTriChon[m];
    	for (i = 1; i <= m; i++) {
			cout << ">>>>>>>> Nhap Dau Cho Phuong Trinh " << i << " (1: Ax >= B; 2: Ax <= B; 3: Ax = B): ";
			cin >> viTriChon[i-1];
			if(viTriChon[i-1] != 3) {
				countTrung++;
			}
			if (viTriChon[i-1] > 3) {
				printf("Err: Co loi khi nhap du lieu!");
				return 0;
			}
	    }
	    if (check3 != 1 && check3 != 2) {
			printf("Err: Co loi khi nhap du lieu chon min max!!!");
			return 0;
		}
	    int nNew = n + countTrung;	//3 + 2 = 5
   		int hangNew = m + 1;	// 3 + 1 = 4
   		double sNew[hangNew][countTrung];	//[4][2]
   		int soVi1 = 0;
   		int soVi2 = 0;
   		int soVi3;
   		
   		for (i = 0; i < hangNew; i++) {		//4
   		   soVi3 = 0;
		   for (j = 0; j < countTrung; j++) {	//2
				//sNew[i][j] = 0;
				if (j == i - soVi1 && i != 0 && viTriChon[j+soVi2] == 3) {			// 2 1 3
					sNew[i][j] = 0;
					soVi2++;
					soVi3++;
				} else if (j == i - soVi1 && i != 0 && viTriChon[j+soVi2] == 2) {
					sNew[i][j] = 1;
				} else if (j == i - soVi1 && i != 0 && viTriChon[j+soVi2] == 1) {
					sNew[i][j] = -1;
				} else {
					sNew[i][j] = 0;
					soVi3++;
				}
				if (soVi3 == (countTrung)) {
					soVi1++;
					//cout << "-sovi: " << j << ": "<< soVi1;
				}
		   }
		}

	    for (i = 0; i <= m; i++) {
			for (j = n+1; j <= nNew; j++) {
				s[i][j] = sNew[i][j-(n+1)]; 
			}
		}
		cout << "-----------Du Lieu Va Bang Don Hinh:-----------"<< endl << "m,n,ep,gz = " << m << "   " << nNew << "  " << eps << "   " << gz << endl;
		for (i = 0; i <= m; i++) {
			cout << "Dong " << i << ": ";
			for (j = 0; j <= nNew; j++) {
				cout << s[i][j] << "  ";
			}
			cout << endl;
	    }
	    if(check3 == 1) {
	    	simplexMax(m, n, eps, gz, s, viTri, check1, countTrung);
		} else if (check3 ==2) {
			simplexMin(m, n, eps, gz, s, viTri, check1, countTrung);
		}
   }	
}


