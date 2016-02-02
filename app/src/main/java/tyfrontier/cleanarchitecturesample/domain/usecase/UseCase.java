package tyfrontier.cleanarchitecturesample.domain.usecase;

public interface UseCase<T, E> {

    E call(T input);
}