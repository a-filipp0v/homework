/*19.09.2017*/
package com.epam.courses.jf.practice.filippov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestableTask13 implements ITestableTask13 {
    @Override
    public ITestableTask13.AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    class Graph extends AbstractGraph {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        private Graph(int numberNodes) {
            super(numberNodes);
            graph = new HashMap<>(numberNodes);
        }

        public void addEdge(int first, int second) {
            if (!isExistEdge(first, second)) {
                list.add(second);
                graph.put(first, list);
            }
        }

        public void removeEdge(int first, int second) {
            if (isExistEdge(first, second)) {
                graph.remove(first);
            }
        }

        public boolean isExistEdge(int first, int second) {
            return graph.containsKey(first) && graph.containsValue(list);
        }
    }
}
