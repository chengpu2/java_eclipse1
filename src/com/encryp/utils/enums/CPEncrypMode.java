package com.encryp.utils.enums;

public enum CPEncrypMode {
	MODE1(new int[]{0,1,2,3}),
	MODE2(new int[]{0,1,3,2}),
	MODE3(new int[]{0,2,1,3}),
	MODE4(new int[]{0,2,3,1}),
	MODE5(new int[]{0,3,1,2}),
	MODE6(new int[]{0,3,2,1}),
	MODE7(new int[]{1,0,2,3}),
	MODE8(new int[]{1,0,3,2}),
	MODE9(new int[]{1,2,0,3}),
	MODE10(new int[]{1,2,3,0}),
	MODE11(new int[]{1,3,0,2}),
	MODE12(new int[]{1,3,2,0}),
	MODE13(new int[]{2,0,1,3}),
	MODE14(new int[]{2,0,3,1}),
	MODE15(new int[]{2,1,0,3}),
	MODE16(new int[]{2,1,3,0}),
	MODE17(new int[]{2,3,0,1}),
	MODE18(new int[]{2,3,1,0}),
	MODE19(new int[]{3,0,1,2}),
	MODE20(new int[]{3,0,2,1}),
	MODE21(new int[]{3,1,0,2}),
	MODE22(new int[]{3,1,2,0}),
	MODE23(new int[]{3,2,0,1}),
	MODE24(new int[]{3,2,1,0});
	private int[] mode;
	private CPEncrypMode(int[] mode){
		this.mode= mode;
	}
	public int[] getMode() {
		return mode;
	}
}
