/**
 * Created by alexey on 25.02.16.
 */

/**
 * Represents commonly used directions.
 */
public enum PredefinedDirection {

    /**
     * Northern direction.
     */
    NORTH {
        @Override
        public PredefinedDirection getOpposite() {
            return SOUTH;
        }

        @Override
        public int getAzimuth() {
            return 0;
        }
    },

    /**
     * North-eastern direction.
     */
    NORTHEAST {
        @Override
        public PredefinedDirection getOpposite() {
            return SOUTHWEST;
        }

        @Override
        public int getAzimuth() {
            return 45;
        }
    },

    /**
     * Eastern direction.
     */
    EAST {
        @Override
        public PredefinedDirection getOpposite() {
            return WEST;
        }

        @Override
        public int getAzimuth() {
            return 90;
        }
    },

    /**
     * South-eastern direction.
     */
    SOUTHEAST {
        @Override
        public PredefinedDirection getOpposite() {
            return NORTHWEST;
        }

        @Override
        public int getAzimuth() {
            return 135;
        }
    },

    /**
     * Southern direction.
     */
    SOUTH {
        @Override
        public PredefinedDirection getOpposite() {
            return NORTH;
        }

        @Override
        public int getAzimuth() {
            return 180;
        }
    },

    /**
     * South-western direction.
     */
    SOUTHWEST {
        @Override
        public PredefinedDirection getOpposite() {
            return NORTHEAST;
        }

        @Override
        public int getAzimuth() {
            return 225;
        }
    },

    /**
     * Western direction.
     */
    WEST {
        @Override
        public PredefinedDirection getOpposite() {
            return EAST;
        }

        @Override
        public int getAzimuth() {
            return 270;
        }
    },

    /**
     * North-western direction.
     */
    NORTHWEST {
        @Override
        public PredefinedDirection getOpposite() {
            return SOUTHEAST;
        }

        @Override
        public int getAzimuth() {
            return 315;
        }
    };

    /**
     * Returns predefined direction that is opposite to current.
     * @return Predefined direction that is opposite to current.
     */
    public abstract PredefinedDirection getOpposite();

    /**
     * Returns azimuth that is associated with current predefined direction.
     * @return Azimuth that is associated with current predefined direction.
     */
    public abstract int getAzimuth();
}
