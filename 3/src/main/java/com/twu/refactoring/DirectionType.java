package com.twu.refactoring;

public enum DirectionType {
    N(){
        @Override
        DirectionType turnLeft() {
            return W;
        }

        @Override
        DirectionType turnRight() {
            return E;
        }
    },E(){
        @Override
        DirectionType turnLeft() {
            return N;
        }

        @Override
        DirectionType turnRight() {
            return S;
        }
    },S(){
        @Override
        DirectionType turnLeft() {
            return E;
        }

        @Override
        DirectionType turnRight() {
            return W;
        }
    },W(){
        @Override
        DirectionType turnLeft() {
            return S;
        }

        @Override
        DirectionType turnRight() {
            return N;
        }
    };

    public static DirectionType getType(char direction) {
        switch (direction) {
            case 'N':
                return DirectionType.N;
            case 'S':
                return DirectionType.S;
            case 'E':
                return DirectionType.E;
            case 'W':
                return DirectionType.W;
            default:
                throw new IllegalArgumentException();
        }
    }

    abstract DirectionType turnLeft();
    abstract DirectionType turnRight();
}
