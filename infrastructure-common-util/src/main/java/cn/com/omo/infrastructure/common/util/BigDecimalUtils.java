package cn.com.omo.infrastructure.common.util;

import java.math.BigDecimal;

/**
 * @author hezh
 *
 */
public class BigDecimalUtils {

	public final static BigDecimal ZERO = BigDecimal.ZERO;
	public final static BigDecimal HUNDRED = new BigDecimal(100);

	/**
	 * Compares this {@code BigDecimal} with the <b>ZERO</b>.
	 * 
	 * @param val
	 *            {@code BigDecimal} to <b>ZERO</b> to be compared.
	 * @return true as this {@code BigDecimal} is numerically less than
	 *         {@code val}, else false
	 */
	public static boolean lessThanZero(BigDecimal bd) {
		return less(bd, ZERO);
	}

	/**
	 * Compares this {@code BigDecimal} with the <b>ZERO</b>.
	 * 
	 * @param val
	 *            {@code BigDecimal} to <b>ZERO</b> to be compared.
	 * @return true as this {@code BigDecimal} is numerically equal to
	 *         {@code val}, else false
	 */
	public static boolean equal2Zero(BigDecimal bd) {
		return equal(bd, ZERO);
	}

	/**
	 * Compares this {@code BigDecimal} with the <b>ZERO</b>.
	 * 
	 * @param val
	 *            {@code BigDecimal} to <b>ZERO</b> to be compared.
	 * @return true as this {@code BigDecimal} is numerically greater than
	 *         {@code val}, else false
	 */
	public static boolean greaterThanZero(BigDecimal bd) {
		return greater(bd, ZERO);
	}

	/**
	 * Compares this {@code BigDecimal} with the specified
	 * {@code BigDecimal}.  
	 *
	 * @param  val {@code BigDecimal} to which this {@code BigDecimal} is
	 *         to be compared.
	 * @return true as this {@code BigDecimal} is numerically less than
	 *         {@code val}, else false
	 */
	public static boolean less(BigDecimal bd1, BigDecimal bd2) {
		if (isNull(bd1) || isNull(bd2)) {
			return false;
		}

		if (bd1.compareTo(bd2) < 0) {
			return true;
		}

		return false;
	}

	/**
	 * Compares this {@code BigDecimal} with the specified
	 * {@code BigDecimal}.  
	 *
	 * @param  val {@code BigDecimal} to which this {@code BigDecimal} is
	 *         to be compared.
	 * @return true as this {@code BigDecimal} is numerically equal to
	 *         {@code val}, else false
	 */
	public static boolean equal(BigDecimal bd1, BigDecimal bd2) {
		if (isNull(bd1) || isNull(bd2)) {
			return false;
		}

		if (bd1.compareTo(bd2) == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Compares this {@code BigDecimal} with the specified
	 * {@code BigDecimal}.  
	 *
	 * @param  val {@code BigDecimal} to which this {@code BigDecimal} is
	 *         to be compared.
	 * @return true as this {@code BigDecimal} is numerically greater than
	 *         {@code val}, else false
	 */
	public static boolean greater(BigDecimal bd1, BigDecimal bd2) {
		if (isNull(bd1) || isNull(bd2)) {
			return false;
		}

		if (bd1.compareTo(bd2) > 0) {
			return true;
		}

		return false;
	}

	public static BigDecimal null2Zero(BigDecimal bd) {
		if (isNull(bd)) {
			return ZERO;
		} else {
			return bd;
		}
	}

	public static boolean isNull(BigDecimal bd) {
		return (bd == null);
	}

	public static BigDecimal divideHalfUpAndKeepTwo(BigDecimal bd1, BigDecimal bd2) {
		return bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_UP);
	}

	public static boolean notGreater(BigDecimal bd1, BigDecimal bd2) {
	    return !greater(bd1, bd2);
	}

	public static boolean notLess(BigDecimal bd1, BigDecimal bd2) {
	    return !less(bd1, bd2);
	}
}
