package de.lexoland.api.easings;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Easings from
 * <a href="https://easings.net">https://easings.net</a>
 * @author Lex305
 */
public enum EasingType {
	
	/**
	 * <img src="http://lexoland.net/api/LINEAR.png" alt="">
	 */
	LINEAR {
		@Override
		public double ease(double x) {
			return x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/SINE_IN.png" alt="">
	 */
	SINE_IN {
		@Override
		public double ease(double x) {
			return 1 - cos((x * PI) / 2);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/SINE_OUT.png" alt="">
	 */
	SINE_OUT {
		@Override
		public double ease(double x) {
			return sin((x * PI) / 2);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/SINE_IN_OUT.png" alt="">
	 */
	SINE_IN_OUT {
		@Override
		public double ease(double x) {
			return -(cos(PI * x) - 1) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUAD_IN.png" alt="">
	 */
	QUAD_IN {
		@Override
		public double ease(double x) {
			return x * x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUAD_OUT.png" alt="">
	 */
	QUAD_OUT {
		@Override
		public double ease(double x) {
			return 1 - (1 - x) * (1 - x);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUAD_IN_OUT.png" alt="">
	 */
	QUAD_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? 2 * x * x : 1 - pow(-2 * x + 2, 2) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CUBIC_IN.png" alt="">
	 */
	CUBIC_IN {
		@Override
		public double ease(double x) {
			return x * x * x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CUBIC_OUT.png" alt="">
	 */
	CUBIC_OUT {
		@Override
		public double ease(double x) {
			return 1 - pow(1 - x, 3);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CUBIC_IN_OUT.png" alt="">
	 */
	CUBIC_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? 4 * x * x * x : 1 - pow(-2 * x + 2, 3) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUART_IN.png" alt="">
	 */
	QUART_IN {
		@Override
		public double ease(double x) {
			return x * x * x * x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUART_OUT.png" alt="">
	 */
	QUART_OUT {
		@Override
		public double ease(double x) {
			return 1 - pow(1 - x, 4);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUART_IN_OUT.png" alt="">
	 */
	QUART_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? 8 * x * x * x * x : 1 - pow(-2 * x + 2, 4) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUINT_IN.png" alt="">
	 */
	QUINT_IN {
		@Override
		public double ease(double x) {
			return x * x * x * x * x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUINT_OUT.png" alt="">
	 */
	QUINT_OUT {
		@Override
		public double ease(double x) {
			return 1 - pow(1 - x, 5);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/QUINT_IN_OUT.png" alt="">
	 */
	QUINT_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? 16 * x * x * x * x * x : 1 - pow(-2 * x + 2, 5) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/EXPO_IN.png" alt="">
	 */
	EXPO_IN {
		@Override
		public double ease(double x) {
			return x == 0 ? 0 : pow(2, 10 * x - 10);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/EXPO_OUT.png" alt="">
	 */
	EXPO_OUT {
		@Override
		public double ease(double x) {
			return x == 1 ? 1 : 1 - pow(2, -10 * x);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/EXPO_IN_OUT.png" alt="">
	 */
	EXPO_IN_OUT {
		@Override
		public double ease(double x) {
			return x == 0 ? 0 : x == 1 ? 1 : x < 0.5 ? pow(2, 20 * x - 10) / 2 : (2 - pow(2, -20 * x + 10)) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CIRC_IN.png" alt="">
	 */
	CIRC_IN {
		@Override
		public double ease(double x) {
			return 1 - sqrt(1 - pow(x, 2));
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CIRC_OUT.png" alt="">
	 */
	CIRC_OUT {
		@Override
		public double ease(double x) {
			return sqrt(1 - pow(x - 1, 2));
		}
	},
	/**
	 * <img src="http://lexoland.net/api/CIRC_IN_OUT.png" alt="">
	 */
	CIRC_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? (1 - sqrt(1 - pow(2 * x, 2))) / 2 : (sqrt(1 - pow(-2 * x + 2, 2)) + 1) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BACK_IN.png" alt="">
	 */
	BACK_IN {
		@Override
		public double ease(double x) {
			final double c1 = 1.70158;
			final double c3 = c1 + 1;
			return c3 * x * x * x - c1 * x * x;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BACK_OUT.png" alt="">
	 */
	BACK_OUT {
		@Override
		public double ease(double x) {
			final double c1 = 1.70158;
			final double c3 = c1 + 1;
			return 1 + c3 * pow(x - 1, 3) + c1 * pow(x - 1, 2);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BACK_IN_OUT.png" alt="">
	 */
	BACK_IN_OUT {
		@Override
		public double ease(double x) {
			final double c1 = 1.70158;
			final double c2 = c1 * 1.525;
			return x < 0.5 ? (pow(2 * x, 2) * ((c2 + 1) * 2 * x - c2)) / 2 : (pow(2 * x - 2, 2) * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/ELASTIC_IN.png" alt="">
	 */
	ELASTIC_IN {
		@Override
		public double ease(double x) {
			final double c4 = (2 * Math.PI) / 3;
			return x == 0 ? 0 : x == 1 ? 1 : -pow(2, 10 * x - 10) * sin((x * 10 - 10.75) * c4);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/ELASTIC_OUT.png" alt="">
	 */
	ELASTIC_OUT {
		@Override
		public double ease(double x) {
			final double c4 = (2 * Math.PI) / 3;
			return x == 0 ? 0 : x == 1 ? 1 : pow(2, -10 * x) * sin((x * 10 - 0.75) * c4) + 1;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/ELASTIC_IN_OUT.png" alt="">
	 */
	ELASTIC_IN_OUT {
		@Override
		public double ease(double x) {
			final double c5 = (2 * Math.PI) / 4.5;
			return x == 0 ? 0 : x == 1 ? 1 : x < 0.5 ? -(pow(2, 20 * x - 10) * sin((20 * x - 11.125) * c5)) / 2 : (pow(2, -20 * x + 10) * sin((20 * x - 11.125) * c5)) / 2 + 1;
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BOUNCE_IN.png" alt="">
	 */
	BOUNCE_IN {
		@Override
		public double ease(double x) {
			return 1 - EasingType.BOUNCE_OUT.ease(1 - x);
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BOUNCE_OUT.png" alt="">
	 */
	BOUNCE_OUT {
		@Override
		public double ease(double x) {
			final double n1 = 7.5625;
			final double d1 = 2.75;

			if (x < 1 / d1) {
			    return n1 * x * x;
			} else if (x < 2 / d1) {
			    return n1 * (x -= 1.5 / d1) * x + 0.75;
			} else if (x < 2.5 / d1) {
			    return n1 * (x -= 2.25 / d1) * x + 0.9375;
			} else {
			    return n1 * (x -= 2.625 / d1) * x + 0.984375;
			}
		}
	},
	/**
	 * <img src="http://lexoland.net/api/BOUNCE_IN_OUT.png" alt="">
	 */
	BOUNCE_IN_OUT {
		@Override
		public double ease(double x) {
			return x < 0.5 ? (1 - EasingType.BOUNCE_OUT.ease(1 - 2 * x)) / 2 : (1 + EasingType.BOUNCE_OUT.ease(2 * x - 1)) / 2;
		}
	};
	
	private EasingType() {}
	
	public double ease(final double x) {
		return x;
	}

}
