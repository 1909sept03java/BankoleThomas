package com.revature.beans;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reimbursements {

	
	
	
	double reimbursementBalance;
	String reimbursementStatus; // 
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Reimbursements() {
		super();
	}
	public Reimbursements(double reimbursementBalance, String reimbursementStatus, String name) {
		super();
		
		this.reimbursementBalance = reimbursementBalance;
		this.reimbursementStatus = reimbursementStatus;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Reimbursements [reimbursementBalance=" + reimbursementBalance + ", reimbursementStatus="
				+ reimbursementStatus + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbursementBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbursementStatus == null) ? 0 : reimbursementStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursements other = (Reimbursements) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(reimbursementBalance) != Double.doubleToLongBits(other.reimbursementBalance))
			return false;
		if (reimbursementStatus == null) {
			if (other.reimbursementStatus != null)
				return false;
		} else if (!reimbursementStatus.equals(other.reimbursementStatus))
			return false;
		return true;
	}
	
	public int length() {
		return name.length();
	}
	public boolean isEmpty() {
		return name.isEmpty();
	}
	public char charAt(int index) {
		return name.charAt(index);
	}
	public int codePointAt(int index) {
		return name.codePointAt(index);
	}
	public int codePointBefore(int index) {
		return name.codePointBefore(index);
	}
	public int codePointCount(int beginIndex, int endIndex) {
		return name.codePointCount(beginIndex, endIndex);
	}
	public int offsetByCodePoints(int index, int codePointOffset) {
		return name.offsetByCodePoints(index, codePointOffset);
	}
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		name.getChars(srcBegin, srcEnd, dst, dstBegin);
	}
	
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return name.getBytes(charsetName);
	}
	public byte[] getBytes(Charset charset) {
		return name.getBytes(charset);
	}
	public byte[] getBytes() {
		return name.getBytes();
	}
	public boolean contentEquals(StringBuffer sb) {
		return name.contentEquals(sb);
	}
	public boolean contentEquals(CharSequence cs) {
		return name.contentEquals(cs);
	}
	public boolean equalsIgnoreCase(String anotherString) {
		return name.equalsIgnoreCase(anotherString);
	}
	public int compareTo(String anotherString) {
		return name.compareTo(anotherString);
	}
	public int compareToIgnoreCase(String str) {
		return name.compareToIgnoreCase(str);
	}
	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		return name.regionMatches(toffset, other, ooffset, len);
	}
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		return name.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}
	public boolean startsWith(String prefix, int toffset) {
		return name.startsWith(prefix, toffset);
	}
	public boolean startsWith(String prefix) {
		return name.startsWith(prefix);
	}
	public boolean endsWith(String suffix) {
		return name.endsWith(suffix);
	}
	public int indexOf(int ch) {
		return name.indexOf(ch);
	}
	public int indexOf(int ch, int fromIndex) {
		return name.indexOf(ch, fromIndex);
	}
	public int lastIndexOf(int ch) {
		return name.lastIndexOf(ch);
	}
	public int lastIndexOf(int ch, int fromIndex) {
		return name.lastIndexOf(ch, fromIndex);
	}
	public int indexOf(String str) {
		return name.indexOf(str);
	}
	public int indexOf(String str, int fromIndex) {
		return name.indexOf(str, fromIndex);
	}
	public int lastIndexOf(String str) {
		return name.lastIndexOf(str);
	}
	public int lastIndexOf(String str, int fromIndex) {
		return name.lastIndexOf(str, fromIndex);
	}
	public String substring(int beginIndex) {
		return name.substring(beginIndex);
	}
	public String substring(int beginIndex, int endIndex) {
		return name.substring(beginIndex, endIndex);
	}
	public CharSequence subSequence(int beginIndex, int endIndex) {
		return name.subSequence(beginIndex, endIndex);
	}
	public String concat(String str) {
		return name.concat(str);
	}
	public String replace(char oldChar, char newChar) {
		return name.replace(oldChar, newChar);
	}
	public boolean matches(String regex) {
		return name.matches(regex);
	}
	public boolean contains(CharSequence s) {
		return name.contains(s);
	}
	public String replaceFirst(String regex, String replacement) {
		return name.replaceFirst(regex, replacement);
	}
	public String replaceAll(String regex, String replacement) {
		return name.replaceAll(regex, replacement);
	}
	public String replace(CharSequence target, CharSequence replacement) {
		return name.replace(target, replacement);
	}
	public String[] split(String regex, int limit) {
		return name.split(regex, limit);
	}
	public String[] split(String regex) {
		return name.split(regex);
	}
	public String toLowerCase(Locale locale) {
		return name.toLowerCase(locale);
	}
	public String toLowerCase() {
		return name.toLowerCase();
	}
	public String toUpperCase(Locale locale) {
		return name.toUpperCase(locale);
	}
	public String toUpperCase() {
		return name.toUpperCase();
	}
	public String trim() {
		return name.trim();
	}
	public String strip() {
		return name.strip();
	}
	public String stripLeading() {
		return name.stripLeading();
	}
	public String stripTrailing() {
		return name.stripTrailing();
	}
	public boolean isBlank() {
		return name.isBlank();
	}
	public Stream<String> lines() {
		return name.lines();
	}
	public IntStream chars() {
		return name.chars();
	}
	public IntStream codePoints() {
		return name.codePoints();
	}
	public char[] toCharArray() {
		return name.toCharArray();
	}
	public String intern() {
		return name.intern();
	}
	public String repeat(int count) {
		return name.repeat(count);
	}
	public double getReimbursementBalance() {
		return reimbursementBalance;
	}
	public void setReimbursementBalance(double reimbursementBalance) {
		this.reimbursementBalance = reimbursementBalance;
	}
	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}
	
	
}